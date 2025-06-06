package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ExecuteCommand
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readString

class ConsoleCommandDecoder : Decoder(BYTE) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        packet.readUByte()
        packet.readUByte()
        val command = packet.readString()
        val parts = command.split(" ")
        val prefix = parts[0]
        return ExecuteCommand(prefix, command.removePrefix(prefix).trim())
    }

}
