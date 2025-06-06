package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractNPC(
    val npcIndex: Int,
    val option: Int,
) : Instruction
