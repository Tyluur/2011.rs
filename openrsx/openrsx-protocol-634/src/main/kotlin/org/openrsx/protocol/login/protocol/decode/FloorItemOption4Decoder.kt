package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanSubtract
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class FloorItemOption4Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val run = packet.readBooleanSubtract()
        val x = packet.readUnsignedShortAdd()
        val y = packet.readShortLittleEndian().toInt()
        val id = packet.readShort().toInt()
        return InteractFloorItem(id, x, y, 3)
    }

}
