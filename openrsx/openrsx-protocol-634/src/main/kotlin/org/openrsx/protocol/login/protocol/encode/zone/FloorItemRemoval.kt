package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class FloorItemRemoval(
    val tile: Int,
    val id: Int,
    val owner: String?
) : ZoneUpdate(
    Protocol.FLOOR_ITEM_REMOVE,
    Protocol.Batch.FLOOR_ITEM_REMOVE,
    3
) {
    override val private: Boolean
        get() = owner != null
    override fun visible(owner: String) = this.owner == null || this.owner == owner
}
