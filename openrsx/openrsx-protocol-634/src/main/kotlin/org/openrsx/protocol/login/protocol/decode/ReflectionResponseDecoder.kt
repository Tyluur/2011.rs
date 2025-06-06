package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

class ReflectionResponseDecoder : Decoder(BYTE) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        packet.readByte()
        return null
    }

}
