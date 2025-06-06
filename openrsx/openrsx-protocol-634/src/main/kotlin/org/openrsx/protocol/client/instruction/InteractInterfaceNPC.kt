package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractInterfaceNPC(
    val npcIndex: Int,
    val interfaceId: Int,
    val componentId: Int,
    val itemId: Int,
    val itemSlot: Int
) : Instruction
