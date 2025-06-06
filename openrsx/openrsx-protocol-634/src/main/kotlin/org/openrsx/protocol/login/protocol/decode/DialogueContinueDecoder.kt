package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractDialogue
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readShortAdd
import org.openrsx.protocol.login.protocol.readUnsignedIntMiddle

class DialogueContinueDecoder : Decoder(6) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val button = packet.readShortAdd()
        val packed = packet.readUnsignedIntMiddle()
        return InteractDialogue(InterfaceDefinition.id(packed), InterfaceDefinition.componentId(packed), button)
    }

}
