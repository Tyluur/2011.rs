package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

@JvmInline
value class ExamineNpc(
    val npcId: Int
) : Instruction
