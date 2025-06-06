package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanInverse
import org.openrsx.protocol.login.protocol.readShortAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class FloorItemOption2Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readUnsignedShortAdd()
        val id = packet.readShortAdd()
        val x = packet.readShortLittleEndian().toInt()
        val run = packet.readBooleanInverse()
        return InteractFloorItem(id, x, y, 1)
    }

}
