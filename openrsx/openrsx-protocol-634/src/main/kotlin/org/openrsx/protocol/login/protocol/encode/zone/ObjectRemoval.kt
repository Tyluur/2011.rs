package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class ObjectRemoval(
    val tile: Int,
    val type: Int,
    val rotation: Int
) : ZoneUpdate(
    Protocol.OBJECT_REMOVE,
    Protocol.Batch.OBJECT_REMOVE,
    2
)
