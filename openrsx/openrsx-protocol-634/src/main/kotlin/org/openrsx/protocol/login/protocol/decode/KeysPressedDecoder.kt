package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.login.protocol.Decoder

/**
 * key's pressed - Pair<Key, Time>
 */
class KeysPressedDecoder : Decoder(BYTE) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction? {
        val keys = ArrayList<Pair<Int, Int>>()
        while (packet.remaining > 0) {
            keys.add(packet.readUByte().toInt() to packet.readUShort().toInt())
        }
        return null
    }

}
