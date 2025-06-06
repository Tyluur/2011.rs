package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractObject
import org.openrsx.protocol.login.protocol.*

class ObjectOption2Decoder : Decoder(7) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val y = packet.readShortAddLittle()
        val x = packet.readUnsignedShortAdd()
        val run = packet.readBooleanSubtract()
        val objectId = packet.readUnsignedShortAddLittle()
        return InteractObject(objectId, x, y, 2)
    }

}
