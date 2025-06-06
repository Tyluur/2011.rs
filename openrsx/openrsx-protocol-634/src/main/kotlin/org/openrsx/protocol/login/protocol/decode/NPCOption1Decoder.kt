package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractNPC
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBoolean

class NPCOption1Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val run = packet.readBoolean()
        val npcIndex = packet.readShortLittleEndian().toInt()
        return InteractNPC(npcIndex, 1)
    }

}
