package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

/**
 * Notified the type of message before a message is sent
 * @param type The type of message sent (0 = public, 1 = clan chat)
 */
data class ChatTypeChange(
    val type: Int
) : Instruction
