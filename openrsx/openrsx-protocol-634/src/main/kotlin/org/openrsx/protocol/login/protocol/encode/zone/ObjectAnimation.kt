package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class ObjectAnimation(
    val tile: Int,
    val id: Int,
    val type: Int,
    val rotation: Int
) : ZoneUpdate(
    Protocol.OBJECT_ANIMATION_SPECIFIC,
    Protocol.Batch.OBJECT_ANIMATION_SPECIFIC,
    4
)
