package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.bits.*
import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractObject
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanSubtract
import org.openrsx.protocol.login.protocol.readShortAddLittle

class ObjectOption1Decoder : Decoder(7) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val run = packet.readBooleanSubtract()
        val x = packet.readShortAddLittle()
        val y = packet.readUShort().reverseByteOrder().toInt()
        val objectId = packet.readUShort().toInt()
        return InteractObject(objectId, x, y, 1)
    }

}
