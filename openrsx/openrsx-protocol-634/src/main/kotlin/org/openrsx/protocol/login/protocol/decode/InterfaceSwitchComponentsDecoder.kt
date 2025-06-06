package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.MoveInventoryItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readShortAddLittle
import org.openrsx.protocol.login.protocol.readUnsignedIntMiddle

class InterfaceSwitchComponentsDecoder : Decoder(16) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val fromPacked = packet.readInt()
        val toSlot = packet.readShortLittleEndian().toInt()
        val toPacked = packet.readUnsignedIntMiddle()
        val toItemId = packet.readShort().toInt()
        val fromSlot = packet.readShortAddLittle()
        val fromItemId = packet.readShortAddLittle()
        return MoveInventoryItem(
            fromId = InterfaceDefinition.id(fromPacked),
            fromComponentId = InterfaceDefinition.componentId(fromPacked),
            fromItemId = fromItemId,
            fromSlot = fromSlot,
            toId = InterfaceDefinition.id(toPacked),
            toComponentId = InterfaceDefinition.componentId(toPacked),
            toItemId = toItemId,
            toSlot = toSlot
        )
    }

}
