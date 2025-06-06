package org.openrsx.protocol.client.instruction

import org.openrsx.protocol.client.Instruction

data class FriendAdd(
    val friendsName: String
) : Instruction
