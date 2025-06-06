package org.openrsx.protocol.login.protocol.encode

import org.openrsx.protocol.client.Client
import org.openrsx.protocol.client.Client.Companion.BYTE
import org.openrsx.protocol.client.Client.Companion.SHORT
import org.openrsx.protocol.client.Client.Companion.string
import org.openrsx.protocol.login.Protocol.CLIENT_VARC_STR
import org.openrsx.protocol.login.Protocol.CLIENT_VARC_STR_LARGE
import org.openrsx.protocol.login.protocol.writeShortAdd
import org.openrsx.protocol.login.protocol.writeShortAddLittle
import org.openrsx.protocol.login.protocol.writeString

/**
 * Client variable; also known as "GlobalString"
 * @param id The config id
 * @param value The value to pass to the config
 */
fun Client.sendVarcStr(id: Int, value: String) {
    val size = 2 + string(value)
    if (size in 0..Byte.MAX_VALUE) {
        send(CLIENT_VARC_STR, size, BYTE) {
            writeString(value)
            writeShortAdd(id)
        }
    } else {
        send(CLIENT_VARC_STR_LARGE, size, SHORT) {
            writeShortAddLittle(id)
            writeString(value)
        }
    }
}
