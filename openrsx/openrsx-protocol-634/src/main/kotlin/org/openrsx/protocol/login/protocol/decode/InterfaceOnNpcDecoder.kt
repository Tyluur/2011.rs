package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractInterfaceNPC
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanAdd
import org.openrsx.protocol.login.protocol.readShortAddLittle
import org.openrsx.protocol.login.protocol.readUnsignedShortAdd

class InterfaceOnNpcDecoder : Decoder(11) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val slot = packet.readShortAddLittle()
        val packed = packet.readInt()
        val npc = packet.readShortLittleEndian().toInt()
        val run = packet.readBooleanAdd()
        val itemId = packet.readUnsignedShortAdd()
        return InteractInterfaceNPC(
            npc,
            InterfaceDefinition.id(packed),
            InterfaceDefinition.componentId(packed),
            itemId,
            slot
        )
    }

}
