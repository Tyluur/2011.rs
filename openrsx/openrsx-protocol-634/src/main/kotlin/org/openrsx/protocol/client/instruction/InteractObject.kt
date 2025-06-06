package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractObject(
    val objectId: Int,
    val x: Int,
    val y: Int,
    val option: Int
) : Instruction
