package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class MoveInventoryItem(
    val fromId: Int,
    val fromComponentId: Int,
    val fromItemId: Int,
    val fromSlot: Int,
    val toId: Int,
    val toComponentId: Int,
    val toItemId: Int,
    val toSlot: Int
) : Instruction
