package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractInterface
import org.openrsx.protocol.login.protocol.Decoder

class InterfaceOptionDecoder(private val index: Int) : Decoder(8) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val packed = packet.readInt()
        return InteractInterface(
            interfaceId = InterfaceDefinition.id(packed),
            componentId = InterfaceDefinition.componentId(packed),
            itemId = packet.readShort().toInt(),
            itemSlot = packet.readShort().toInt(),
            option = index
        )
    }

}
