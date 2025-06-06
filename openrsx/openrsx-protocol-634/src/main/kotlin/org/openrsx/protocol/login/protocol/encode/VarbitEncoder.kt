package org.openrsx.protocol.login.protocol.encode

import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.CLIENT_VARBIT
import org.openrsx.protocol.login.Protocol.CLIENT_VARBIT_LARGE
import org.openrsx.protocol.login.protocol.writeByteAdd
import org.openrsx.protocol.login.protocol.writeIntInverseMiddle
import org.openrsx.protocol.login.protocol.writeShortAdd
import org.openrsx.protocol.login.protocol.writeShortLittle

/**
 * A variable bit; also known as "ConfigFile", known in the client as "clientvarpbit"
 * @param id The file id
 * @param value The value to pass to the config file
 */
fun Client.sendVarbit(id: Int, value: Int) {
    if (value in Byte.MIN_VALUE..Byte.MAX_VALUE) {
        send(CLIENT_VARBIT) {
            writeByteAdd(value)
            writeShortLittle(id)
        }
    } else {
        send(CLIENT_VARBIT_LARGE) {
            writeShortAdd(id)
            writeIntInverseMiddle(value)
        }
    }
}
