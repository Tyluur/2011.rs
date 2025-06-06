package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractInterfaceItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readShortAdd
import org.openrsx.protocol.login.protocol.readUnsignedIntInverseMiddle

class InterfaceOnInterfaceDecoder : Decoder(16) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val toPacked = packet.readInt()
        val fromPacked = packet.readUnsignedIntInverseMiddle()
        val fromSlot = packet.readShortAdd()
        val fromItem = packet.readShort().toInt()
        val toSlot = packet.readShortAdd()
        val toItem = packet.readShort().toInt()
        return InteractInterfaceItem(
            fromItem,
            toItem,
            fromSlot,
            toSlot,
            InterfaceDefinition.id(fromPacked),
            InterfaceDefinition.componentId(fromPacked),
            InterfaceDefinition.id(toPacked),
            InterfaceDefinition.componentId(toPacked)
        )
    }

}
