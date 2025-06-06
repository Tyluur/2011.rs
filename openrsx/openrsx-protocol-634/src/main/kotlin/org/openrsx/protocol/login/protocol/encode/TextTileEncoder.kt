package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.client.Client.Companion.BYTE
import org.openrsx.protocol.client.Client.Companion.string
import org.openrsx.protocol.login.Protocol.TILE_TEXT
import org.openrsx.protocol.login.protocol.writeMedium
import org.openrsx.protocol.login.protocol.writeString

fun Client.tileText(
    tile: Int,
    duration: Int,
    height: Int,
    color: Int,
    text: String
) = send(TILE_TEXT, 8 + string(text), BYTE) {
    writeByte(0)
    writeByte(tile)
    writeShort(duration)
    writeByte(height)
    writeMedium(color)
    writeString(text)
}
