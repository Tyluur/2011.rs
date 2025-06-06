package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readShortAddLittle

class SecondaryTeleportDecoder : Decoder(4) {

    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val x = packet.readShortAddLittle()
        val y = packet.readShortLittleEndian().toInt()
        return null
    }

}
