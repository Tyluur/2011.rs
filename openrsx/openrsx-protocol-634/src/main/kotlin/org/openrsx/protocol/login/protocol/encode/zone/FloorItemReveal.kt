package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class FloorItemReveal(
    val tile: Int,
    val id: Int,
    val amount: Int,
    val ownerIndex: Int
) : ZoneUpdate(
    Protocol.FLOOR_ITEM_REVEAL,
    Protocol.Batch.FLOOR_ITEM_REVEAL,
    7
)
