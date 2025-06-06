package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ChangeDisplayMode
import org.openrsx.protocol.login.protocol.Decoder

class ScreenChangeDecoder : Decoder(6) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        return ChangeDisplayMode(
            displayMode = packet.readUByte().toInt(),
            width = packet.readUShort().toInt(),
            height = packet.readUShort().toInt(),
            antialiasLevel = packet.readUByte().toInt()
        )
    }

}
