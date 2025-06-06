package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBoolean
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAddLittle

class FloorItemOption3Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val id = packet.readShort().toInt()
        val x = packet.readUnsignedShortAdd()
        val run = packet.readBoolean()
        val y = packet.readUnsignedShortAddLittle()
        return InteractFloorItem(id, x, y, 2)
    }

}
