package org.openrsx.protocol.login.protocol

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction

abstract class Decoder(val length: Int) {

    abstract suspend fun decode(packet: ByteReadPacket) : Instruction?

    companion object {
        const val BYTE = -1
        const val SHORT = -2
    }
}
