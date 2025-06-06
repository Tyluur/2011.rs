package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class ExecuteCommand(val prefix: String, val content: String) : Instruction
