package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.SongEnd
import org.openrsx.protocol.login.protocol.Decoder

class SongEndDecoder : Decoder(4) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val songIndex = packet.readInt()
        return SongEnd(
            songIndex
        )
    }

}
