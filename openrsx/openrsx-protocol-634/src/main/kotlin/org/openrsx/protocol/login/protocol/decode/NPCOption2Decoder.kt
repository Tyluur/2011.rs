package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractNPC
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readShortAddLittle

class NPCOption2Decoder : Decoder(3) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val npcIndex = packet.readShortAddLittle()
        val run = packet.readBooleanAdd()
        return InteractNPC(npcIndex, 2)
    }

}
