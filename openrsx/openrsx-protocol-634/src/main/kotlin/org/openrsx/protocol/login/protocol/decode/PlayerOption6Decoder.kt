package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractPlayer
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class PlayerOption6Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        packet.readByte()
        val index = packet.readUnsignedShortAdd()
        return InteractPlayer(index, 6)
    }

}
