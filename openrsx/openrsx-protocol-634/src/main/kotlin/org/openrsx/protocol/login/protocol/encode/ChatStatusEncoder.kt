package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.PRIVATE_STATUS
import org.openrsx.protocol.login.Protocol.PUBLIC_STATUS
import org.openrsx.protocol.login.protocol.writeByteAdd
import org.openrsx.protocol.login.protocol.writeByteSubtract

/**
 * @param public (0 = on, 1 = friends, 2 = off, 3 = hide)
 * @param trade (0 = on, 1 = friends, 2 = off)
 */
fun Client.sendPublicStatus(public: Int, trade: Int) {
    send(PUBLIC_STATUS, 2, Client.FIXED) {
        writeByteSubtract(public)
        writeByteAdd(trade)
    }
}

/**
 * @param status (0 = on, 1 = friends, 2 = off)
 */
fun Client.sendPrivateStatus(status: Int) {
    send(PRIVATE_STATUS, 1, Client.FIXED) {
        writeByte(status)
    }
}
