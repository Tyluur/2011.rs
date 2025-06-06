package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.EnterInt
import org.openrsx.protocol.login.protocol.Decoder

class IntegerEntryDecoder : Decoder(4) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val integer = packet.readInt()
        return EnterInt(integer)
    }

}
