package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class Walk(val x: Int, val y: Int, val minimap: Boolean = false) : Instruction
