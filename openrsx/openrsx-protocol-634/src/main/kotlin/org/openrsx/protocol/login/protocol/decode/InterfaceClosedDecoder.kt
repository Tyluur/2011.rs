package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InterfaceClosedInstruction
import org.openrsx.protocol.login.protocol.Decoder

class InterfaceClosedDecoder : Decoder(0) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        return InterfaceClosedInstruction
    }

}
