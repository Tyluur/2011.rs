package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.CLIENT_VARC
import org.openrsx.protocol.login.Protocol.CLIENT_VARC_LARGE
import org.openrsx.protocol.login.protocol.writeIntLittle
import org.openrsx.protocol.login.protocol.writeShortAddLittle
import org.openrsx.protocol.login.protocol.writeShortLittle

/**
 * Client variable; also known as "ConfigGlobal"
 * @param id The config id
 * @param value The value to pass to the config
 */
fun Client.sendVarc(id: Int, value: Int) {
    if (value in Byte.MIN_VALUE..Byte.MAX_VALUE) {
        send(CLIENT_VARC) {
            writeByte(value)
            writeShortAddLittle(id)
        }
    } else {
        send(CLIENT_VARC_LARGE) {
            writeIntLittle(value)
            writeShortLittle(id)
        }
    }
}
