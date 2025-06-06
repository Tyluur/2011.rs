package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

/**
 * A freeform [message] a player wants (but has yet) to send directly to a [friend].
 */
data class ChatPrivate(
    val friend: String,
    val message: String
) : Instruction
