package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readShortAdd

class APCoordinateDecoder : Decoder(12) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val x = packet.readShortLittleEndian()
        val first = packet.readShortAdd()
        val third = packet.readShortLittleEndian()
        val fourth = packet.readInt()
        val y = packet.readShortAdd()
        return null
    }

}
