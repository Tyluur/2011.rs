package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class InteractDialogue(
    val interfaceId: Int,
    val componentId: Int,
    val option: Int
) : Instruction
