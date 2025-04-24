package org.ksystem.app.data.repository

import com.password4j.BcryptFunction
import com.password4j.Password
import com.password4j.types.Bcrypt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ksystem.app.domain.model.properties.TokenProperties


class PasswordManager(
    private val tokenProperties: TokenProperties,
) {
    private val bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12)

    suspend fun match(source: String, encrypted: String): Boolean = withContext(Dispatchers.Default) {
        Password
            .check(source, encrypted)
            .addPepper(tokenProperties.secret)
            .with(bcrypt)
    }

    suspend fun encrypt(password: String): String = withContext(Dispatchers.Default) {
        Password
            .hash(password)
            .addPepper(tokenProperties.secret)
            .with(bcrypt)
            .result
    }
}