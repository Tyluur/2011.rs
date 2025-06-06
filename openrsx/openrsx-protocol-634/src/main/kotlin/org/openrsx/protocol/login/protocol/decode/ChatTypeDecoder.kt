package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ChatTypeChange
import org.openrsx.protocol.login.protocol.Decoder

/**
 * Notified the type of message before a message is sent
 * The type of message sent (0 = public, 1 = clan chat)
 */
class ChatTypeDecoder : Decoder(1) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        return ChatTypeChange(packet.readUByte().toInt())
    }

}
