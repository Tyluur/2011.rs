package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class ChangeDisplayMode(
    val displayMode: Int,
    val width: Int,
    val height: Int,
    val antialiasLevel: Int
) : Instruction
