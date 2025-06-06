package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractInterface(
    val interfaceId: Int,
    val componentId: Int,
    val itemId: Int,
    val itemSlot: Int,
    val option: Int
) : Instruction
