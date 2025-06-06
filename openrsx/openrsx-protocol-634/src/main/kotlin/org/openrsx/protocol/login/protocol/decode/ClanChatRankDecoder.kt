package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ClanChatRank
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readByteSubtract
import org.openrsx.protocol.login.protocol.readString

class ClanChatRankDecoder : Decoder(BYTE) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val rank = packet.readByteSubtract()
        val name = packet.readString()
        return ClanChatRank(name, rank)
    }

}
