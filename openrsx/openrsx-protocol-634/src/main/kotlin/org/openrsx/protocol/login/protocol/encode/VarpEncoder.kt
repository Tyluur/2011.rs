package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.CLIENT_VARP
import org.openrsx.protocol.login.Protocol.CLIENT_VARP_LARGE
import org.openrsx.protocol.login.protocol.writeIntInverseMiddle
import org.openrsx.protocol.login.protocol.writeShortAdd

/**
 * A variable player config; also known as "Config", known in the client as "clientvarp"
 * @param id The config id
 * @param value The value to pass to the config
 */
fun Client.sendVarp(id: Int, value: Int) {
    if (value in Byte.MIN_VALUE..Byte.MAX_VALUE) {
        send(CLIENT_VARP) {
            writeShort(id)
            writeByte(value)
        }
    } else {
        send(CLIENT_VARP_LARGE) {
            writeIntInverseMiddle(value)
            writeShortAdd(id)
        }
    }
}
