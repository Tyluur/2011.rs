package org.openrsx.protocol.login.protocol.encode

import org.openrsx.protocol.client.Client
import org.openrsx.protocol.client.Client.Companion.BYTE
import org.openrsx.protocol.client.Client.Companion.string
import org.openrsx.protocol.login.Protocol.PLAYER_OPTION
import org.openrsx.protocol.login.protocol.writeByteAdd
import org.openrsx.protocol.login.protocol.writeByteSubtract
import org.openrsx.protocol.login.protocol.writeShortAddLittle
import org.openrsx.protocol.login.protocol.writeString

/**
 * Sends a player right click option
 * @param option The option
 * @param slot The index of the option
 * @param top Whether it should be forced to the top?
 * @param cursor Unknown value
 */
fun Client.contextMenuOption(
    option: String?,
    slot: Int,
    top: Boolean,
    cursor: Int = -1
) = send(PLAYER_OPTION, 4 + string(option), BYTE) {
    writeShortAddLittle(cursor)
    writeString(option)
    writeByteSubtract(slot)
    writeByteAdd(top)
}
