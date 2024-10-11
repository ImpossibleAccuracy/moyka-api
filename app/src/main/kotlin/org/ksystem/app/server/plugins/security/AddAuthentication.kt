package org.ksystem.app.server.plugins.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.koin.ktor.ext.get
import org.ksystem.app.domain.constants.JWTConstants
import org.ksystem.app.domain.model.properties.TokenProperties
import org.ksystem.app.domain.repository.AccountRepository
import org.ksystem.app.domain.repository.AuthRepository
import org.ksystem.app.server.model.AccountPrincipal

internal fun Application.addAuthentication() {
    val tokenProperties = get<TokenProperties>()
    val authRepository = get<AuthRepository>()
    val accountRepository = get<AccountRepository>()

    authentication {
        jwt {
            realm = JWTConstants.REALM

            verifier(
                JWT.require(Algorithm.HMAC256(tokenProperties.secret))
                    .withAudience(tokenProperties.audience)
                    .withIssuer(tokenProperties.issuer)
                    .build()
            )

            validate { credential ->
                if (tokenProperties.audience !in credential.payload.audience) return@validate null

                val id = credential[JWTConstants.CLAIM]
                    ?.toInt()
                    ?: return@validate null

                val user = newSuspendedTransaction {
                    accountRepository.getAccount(id).getOrNull()
                } ?: return@validate null

                AccountPrincipal(user)
            }
        }
    }
}