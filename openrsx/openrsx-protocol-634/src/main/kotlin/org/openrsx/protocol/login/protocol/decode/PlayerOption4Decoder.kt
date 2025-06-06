package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractPlayer
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readByteAdd

class PlayerOption4Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val index = packet.readShort().toInt()
        packet.readByteAdd()
        return InteractPlayer(index, 4)
    }

}
