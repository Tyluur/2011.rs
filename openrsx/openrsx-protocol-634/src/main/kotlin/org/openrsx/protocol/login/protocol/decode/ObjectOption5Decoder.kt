package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractObject
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readShortAddLittle
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class ObjectOption5Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readShortLittleEndian().toInt()
        val run = packet.readBooleanAdd()
        val x = packet.readShortAddLittle()
        val objectId = packet.readUnsignedShortAdd() and 0xffff
        return InteractObject(objectId, x, y, 5)
    }

}
