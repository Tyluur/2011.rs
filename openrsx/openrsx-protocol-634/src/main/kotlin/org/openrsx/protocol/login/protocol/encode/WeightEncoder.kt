package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.PLAYER_WEIGHT

/**
 * Updates player weight for equipment screen
 */
fun Client.weight(
    weight: Int
) = send(PLAYER_WEIGHT) {
    writeShort(weight)
}
