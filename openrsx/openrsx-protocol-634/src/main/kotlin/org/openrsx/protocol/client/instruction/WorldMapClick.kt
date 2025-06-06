package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class WorldMapClick(val tile: Int) : Instruction
