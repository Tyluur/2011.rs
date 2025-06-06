package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class ClanChatRank(
    val name: String,
    val rank: Int
) : Instruction
