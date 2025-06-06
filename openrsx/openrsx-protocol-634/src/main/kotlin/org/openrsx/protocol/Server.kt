package org.openrsx.protocol

import io.ktor.utils.io.*

interface Server {
    suspend fun connect(read: ByteReadChannel, write: ByteWriteChannel, hostname: String)
}
