package org.ksystem.app.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> ioCall(block: suspend () -> T): T =
    withContext(Dispatchers.IO) {
        block()
    }

suspend fun <T> runCatchingWithContext(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    block: suspend CoroutineScope.() -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        block()
    }
}
