package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

class LatencyDecoder : Decoder(2) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val value = packet.readShort().toInt()
        return null
    }

}
