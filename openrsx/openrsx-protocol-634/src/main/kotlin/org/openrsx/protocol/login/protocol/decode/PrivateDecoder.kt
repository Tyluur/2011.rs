package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.secure.Huffman
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ChatPrivate
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readSmart
import org.openrsx.protocol.login.protocol.readString

class PrivateDecoder(private val huffman: Huffman) : Decoder(BYTE) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val name = packet.readString()
        val message = huffman.decompress(length = packet.readSmart(), message = packet.readBytes(packet.remaining.toInt())) ?: ""
        return ChatPrivate(name, message)
    }

}
