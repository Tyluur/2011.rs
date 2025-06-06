package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

class MovedCameraDecoder : Decoder(4) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val pitch = packet.readUShort().toInt()
        val yaw = packet.readUShort().toInt()
        return null
    }

}
