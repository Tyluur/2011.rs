package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import world.gregs.voidps.cache.definition.data.InterfaceDefinition
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.InteractInterfacePlayer
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readBooleanInverse
import org.openrsx.protocol.login.protocol.readShortAddLittle
import org.openrsx.protocol.login.protocol.readUnsignedIntInverseMiddle

class InterfaceOnPlayerDecoder : Decoder(11) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val slot = packet.readShortAddLittle()
        val index = packet.readShortLittleEndian().toInt()
        val itemId = packet.readShortLittleEndian().toInt()
        val packed = packet.readUnsignedIntInverseMiddle()
        val run = packet.readBooleanInverse()
        return InteractInterfacePlayer(
            index,
            InterfaceDefinition.id(packed),
            InterfaceDefinition.componentId(packed),
            itemId,
            slot
        )
    }

}
