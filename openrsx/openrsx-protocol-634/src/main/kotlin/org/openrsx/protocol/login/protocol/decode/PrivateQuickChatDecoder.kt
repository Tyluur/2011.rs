package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.QuickChatPrivate
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readString

class PrivateQuickChatDecoder : Decoder(BYTE) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val name = packet.readString()
        val file = packet.readUShort().toInt()
        val data = packet.readBytes(packet.remaining.toInt())
        return QuickChatPrivate(name, file, data)
    }

}
