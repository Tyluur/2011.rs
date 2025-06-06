package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractObject
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd
import org.openrsx.protocol.login.protocol.readUnsignedShortAddLittle

class ObjectOption3Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readUnsignedShortAdd()
        val objectId = packet.readUnsignedShortAddLittle()
        val x = packet.readShortLittleEndian().toInt()
        val run = packet.readBooleanAdd()
        return InteractObject(objectId, x, y, 3)
    }

}
