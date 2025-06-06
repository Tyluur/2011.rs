package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Jun 20, 2021
 */
data class InteractInterfaceItem(
    val fromItem: Int,
    val toItem: Int,
    val fromSlot: Int,
    val toSlot: Int,
    val fromInterfaceId: Int,
    val fromComponentId: Int,
    val toInterfaceId: Int,
    val toComponentId: Int
) : Instruction
