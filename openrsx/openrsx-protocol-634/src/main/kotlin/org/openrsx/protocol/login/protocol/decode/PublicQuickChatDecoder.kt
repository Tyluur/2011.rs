package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.QuickChatPublic
import org.openrsx.protocol.login.protocol.Decoder

class PublicQuickChatDecoder : Decoder(BYTE) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val script = packet.readByte().toInt()
        val file = packet.readUShort().toInt()
        val data = packet.readBytes(packet.remaining.toInt())
        return QuickChatPublic(script, file, data)
    }

}
