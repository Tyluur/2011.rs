package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.Response
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.protocol.writeByte
import org.openrsx.protocol.login.protocol.writeMedium
import org.openrsx.protocol.login.protocol.writeString

fun Client.login(username: String, index: Int, rights: Int, member: Boolean = true, membersWorld: Boolean = true) = send(-1) {
    writeByte(Response.SUCCESS)
    writeByte(13 + Client.string(username))
    writeByte(rights)
    writeByte(0)// Unknown - something to do with skipping chat messages
    writeByte(0)
    writeByte(0)
    writeByte(0)
    writeByte(0)// Moves chat box position
    writeShort(index)
    writeByte(member)
    writeMedium(0)
    writeByte(membersWorld)
    writeString(username)
    flush()
}
