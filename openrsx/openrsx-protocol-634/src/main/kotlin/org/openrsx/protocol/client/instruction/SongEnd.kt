package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class SongEnd(
    val songIndex: Int
): Instruction
