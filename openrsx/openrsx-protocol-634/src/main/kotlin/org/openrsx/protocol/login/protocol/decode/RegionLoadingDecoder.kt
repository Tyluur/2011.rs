package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

class RegionLoadingDecoder : Decoder(4) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        packet.readInt() // 1057001181
        return null
    }

}
