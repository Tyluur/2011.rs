package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class GraphicAddition(
    val tile: Int,
    val id: Int,
    val height: Int,
    val delay: Int,
    val rotation: Int
) : ZoneUpdate(
    Protocol.GRAPHIC_AREA,
    Protocol.Batch.GRAPHIC_AREA,
    7
)
