package org.openrsx.protocol.login.protocol.encode

import world.gregs.voidps.buffer.write.BufferWriter
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.client.Client.Companion.SHORT
import org.openrsx.protocol.login.Protocol.PLAYER_UPDATING
import org.openrsx.protocol.login.protocol.writeBytes

fun Client.updatePlayers(
    changes: BufferWriter,
    updates: BufferWriter
) = send(PLAYER_UPDATING, changes.position() + updates.position(), SHORT) {
    writeBytes(changes.toArray())
    writeBytes(updates.toArray())
}
