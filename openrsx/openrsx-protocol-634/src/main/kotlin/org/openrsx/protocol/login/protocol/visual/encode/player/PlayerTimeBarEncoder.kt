package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.PLAYER_TIME_BAR_MASK

class PlayerTimeBarEncoder : VisualEncoder<PlayerVisuals>(PLAYER_TIME_BAR_MASK) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        val (full, exponentialDelay, delay, increment) = visuals.timeBar
        writer.apply {
            writeShortLittle(((if (full) 1 else 0) * 0x8000) or (exponentialDelay and 0x7fff))
            writeByteSubtract(delay)
            writeByteInverse(increment)
        }
    }

}
