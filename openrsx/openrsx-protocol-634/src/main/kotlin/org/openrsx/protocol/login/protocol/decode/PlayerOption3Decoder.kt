package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractPlayer
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readByteSubtract

class PlayerOption3Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        packet.readByteSubtract()
        val index = packet.readShortLittleEndian().toInt()
        return InteractPlayer(index, 3)
    }

}
