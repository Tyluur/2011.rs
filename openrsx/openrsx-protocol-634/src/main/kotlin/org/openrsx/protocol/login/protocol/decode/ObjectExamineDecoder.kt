package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ExamineObject
import org.openrsx.protocol.login.protocol.Decoder

class ObjectExamineDecoder : Decoder(2) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val objectId = packet.readUShort().toInt()
        return ExamineObject(objectId)
    }

}
