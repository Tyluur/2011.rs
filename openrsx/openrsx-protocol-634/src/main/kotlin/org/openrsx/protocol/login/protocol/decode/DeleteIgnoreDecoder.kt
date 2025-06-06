package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.IgnoreDelete
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readString

class DeleteIgnoreDecoder : Decoder(BYTE) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        return IgnoreDelete(packet.readString())
    }

}
