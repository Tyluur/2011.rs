package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.secure.Huffman
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ChatPublic
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readSmart

class PublicDecoder(private val huffman: Huffman) : Decoder(BYTE) {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val effects = (packet.readUByte().toInt() shl 8) or packet.readUByte().toInt()
        val message = huffman.decompress(length = packet.readSmart(), message = packet.readBytes(packet.remaining.toInt())) ?: ""
        return ChatPublic(message, effects)
    }

}
