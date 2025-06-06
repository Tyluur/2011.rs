package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class IgnoreAdd(
    val name: String
) : Instruction
