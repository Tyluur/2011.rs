package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.PLAYER_ANIMATION_MASK

class PlayerAnimationEncoder : VisualEncoder<PlayerVisuals>(PLAYER_ANIMATION_MASK, initial = true) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        val (first, second, third, fourth, delay) = visuals.animation
        writer.apply {
            writeShortAdd(first)
            writeShortAdd(second)
            writeShortAdd(third)
            writeShortAdd(fourth)
            writeByteAdd(delay)
        }
    }
}
