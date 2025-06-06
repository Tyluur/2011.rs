package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractNPC
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanInverse

class NPCOption5Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val npcIndex = packet.readShort().toInt()
        val run = packet.readBooleanInverse()
        return InteractNPC(npcIndex, 5)
    }

}
