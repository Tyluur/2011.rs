package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractFloorItem(
    val id: Int,
    val x: Int,
    val y: Int,
    val option: Int
) : Instruction
