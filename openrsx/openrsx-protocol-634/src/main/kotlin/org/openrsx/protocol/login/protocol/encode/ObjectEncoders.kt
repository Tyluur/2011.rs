package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol
import org.openrsx.protocol.login.protocol.writeByteAdd
import org.openrsx.protocol.login.protocol.writeIntInverseMiddle
import org.openrsx.protocol.login.protocol.writeShortAddLittle

/**
 * Show animation of an object for a single client
 * @param tile 30 bit location hash
 * @param animation Animation id
 * @param type Object type
 * @param rotation Object rotation
 */
fun Client.animateObject(
    tile: Int,
    animation: Int,
    type: Int,
    rotation: Int
) = send(Protocol.OBJECT_ANIMATION) {
    writeShortAddLittle(animation)
    writeByteAdd((type shl 2) or rotation)
    writeIntInverseMiddle(tile)
}

/**
 * Preloads a object model
 */
fun Client.preloadObject(
    id: Int,
    modelType: Int
) = send(Protocol.OBJECT_PRE_FETCH) {
    writeShort(id)
    writeByte(modelType)
}
