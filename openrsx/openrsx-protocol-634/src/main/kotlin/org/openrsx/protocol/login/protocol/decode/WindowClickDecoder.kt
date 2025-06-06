package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

class WindowClickDecoder : Decoder(6) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val packed = packet.readShort().toInt()
        val position = packet.readInt()
        return null
    }

}
