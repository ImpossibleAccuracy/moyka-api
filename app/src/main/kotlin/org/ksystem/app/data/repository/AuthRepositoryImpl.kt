package org.ksystem.app.data.repository

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import kotlinx.coroutines.Dispatchers
import org.ksystem.app.domain.constants.JWTConstants
import org.ksystem.app.domain.exception.InvalidInputException
import org.ksystem.app.domain.exception.OperationRejectedException
import org.ksystem.app.domain.model.AccountDomain
import org.ksystem.app.domain.model.properties.TokenProperties
import org.ksystem.app.domain.model.security.RoleDomain
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.utils.runCatchingWithContext
import java.util.*

class AuthRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val passwordManager: PasswordManager,
    private val tokenProperties: TokenProperties,
) : AuthRepository {
    override suspend fun signIn(username: String, password: String): Result<AccountDomain> = runCatching {
        accountRepository
            .getAccount(username)
            .getOrNull()
            ?.takeIf {
                passwordManager.match(password, it.password)
            } ?: throw OperationRejectedException("Invalid credentials")
    }

    override suspend fun signUp(
        username: String,
        password: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String,
        phone: String,
    ): Result<AccountDomain> = accountRepository
        .existsByUsername(username)
        .let { exists ->
            if (exists) {
                throw InvalidInputException("Username already taken")
            }
        }
        .let {
            accountRepository.createAccount(
                username = username,
                password = passwordManager.encrypt(password),
                firstName = firstName,
                middleName = middleName,
                lastName = lastName,
                email = email,
                phone = phone,
                role = RoleDomain.USER,
            )
        }

    override suspend fun refreshToken(token: String): Result<AuthRepository.RefreshedToken> =
        runCatchingWithContext(Dispatchers.Default) {
            val decoded = JWT.decode(token)

            val accountId = decoded.claims[JWTConstants.CLAIM]!!
                .asString()
                .toIntOrNull() ?: throw OperationRejectedException("Invalid token content")

            val account = accountRepository.getAccount(accountId).getOrThrow()

            val newToken = generateToken(account).getOrThrow()

            AuthRepository.RefreshedToken(
                account = account,
                token = newToken,
            )
        }

    override suspend fun generateToken(account: AccountDomain): Result<String> = runCatchingWithContext {
        JWT.create()
            .withAudience(tokenProperties.audience)
            .withIssuer(tokenProperties.issuer)
            .withClaim(JWTConstants.CLAIM, account.idValue.toString())
            .withExpiresAt(Date(System.currentTimeMillis() + tokenProperties.ttl))
            .sign(Algorithm.HMAC256(tokenProperties.secret))
    }
}
