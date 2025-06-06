package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractInterfaceFloorItem
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBoolean
import org.openrsx.protocol.login.protocol.readUnsignedIntMiddle
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class InterfaceOnFloorItemDecoder : Decoder(15) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val x = packet.readShortLittleEndian().toInt()
        val floorItem = packet.readUnsignedShortAdd()
        val itemSlot = packet.readShortLittleEndian().toInt()
        val y = packet.readShort().toInt()
        val run = packet.readBoolean()
        val item = packet.readUnsignedShortAdd()
        val packed = packet.readUnsignedIntMiddle()
        return InteractInterfaceFloorItem(
            floorItem,
            x,
            y,
            InterfaceDefinition.id(packed),
            InterfaceDefinition.componentId(packed),
            item,
            itemSlot
        )
    }

}
