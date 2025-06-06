package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

@JvmInline
value class ExamineObject(
    val objectId: Int
) : Instruction
