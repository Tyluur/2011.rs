package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractObject
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class ObjectOption4Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val run = packet.readBooleanAdd()
        val objectId = packet.readUnsignedShortAdd()
        val x = packet.readUnsignedShortAdd()
        val y = packet.readShortLittleEndian().toInt()
        return InteractObject(objectId, x, y, 4)
    }

}
