package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanInverse
import org.openrsx.protocol.login.protocol.readShortAdd

class FloorItemOption5Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readShort().toInt()
        val x = packet.readShortAdd()
        val run = packet.readBooleanInverse()
        val id = packet.readShortAdd()
        return InteractFloorItem(id, x, y, 4)
    }

}
