package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanSubtract

class FloorItemOption1Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val id = packet.readShort().toInt()
        val x = packet.readShort().toInt()
        val y = packet.readShort().toInt()
        val run = packet.readBooleanSubtract()
        return InteractFloorItem(id, x, y, 0)
    }

}
