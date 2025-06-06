package org.openrsx.protocol.login.protocol.encode

import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.SKILL_LEVEL
import org.openrsx.protocol.login.protocol.writeByteInverse
import org.openrsx.protocol.login.protocol.writeByteSubtract
import org.openrsx.protocol.login.protocol.writeIntMiddle

/**
 * Updates the players' skill level & experience
 * @param skill The skills id
 * @param level The current players level
 * @param experience The current players experience
 */
fun Client.skillLevel(
    skill: Int,
    level: Int,
    experience: Int
) = send(SKILL_LEVEL) {
    writeByteSubtract(level)
    writeByteInverse(skill)
    writeIntMiddle(experience)
}
