package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBoolean

class WindowFocusDecoder : Decoder(1) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val focused = packet.readBoolean()
        return null
    }

}
