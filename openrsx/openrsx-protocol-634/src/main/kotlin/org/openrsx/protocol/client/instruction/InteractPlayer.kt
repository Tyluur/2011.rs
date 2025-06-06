package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractPlayer(
    val playerIndex: Int,
    val option: Int
) : Instruction
