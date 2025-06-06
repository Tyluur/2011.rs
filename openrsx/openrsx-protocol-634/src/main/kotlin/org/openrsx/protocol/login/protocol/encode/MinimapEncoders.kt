package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.MINIMAP_STATE

fun Client.sendMinimapState(state: Int) {
    send(MINIMAP_STATE) {
        writeByte(state)
    }
}
