package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.Walk
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class WalkMiniMapDecoder : Decoder(18) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readShortLittleEndian().toInt()
        val running = packet.readBooleanAdd()
        val x = packet.readUnsignedShortAdd()
        packet.readByte()//-1
        packet.readByte()//-1
        packet.readShort()//Rotation?
        packet.readByte()//57
        val minimapRotation = packet.readByte()
        val minimapZoom = packet.readByte()
        packet.readByte()//89
        packet.readShort()//X in region?
        packet.readShort()//Y in region?
        packet.readByte()//63
        return Walk(x, y, minimap = true)
    }

}
