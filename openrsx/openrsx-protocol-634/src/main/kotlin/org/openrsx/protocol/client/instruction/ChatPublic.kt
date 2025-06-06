package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

/**
 * A freeform [text] a player wants (but has yet) to say to everyone nearby.
 */
data class ChatPublic(
    val text: String,
    val effects: Int
) : Instruction
