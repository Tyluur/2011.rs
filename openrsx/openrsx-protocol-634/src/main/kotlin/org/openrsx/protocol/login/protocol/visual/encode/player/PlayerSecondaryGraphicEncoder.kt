package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.PLAYER_GRAPHIC_2_MASK

class PlayerSecondaryGraphicEncoder : VisualEncoder<PlayerVisuals>(PLAYER_GRAPHIC_2_MASK) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        val visual = visuals.secondaryGraphic
        writer.apply {
            writeShortAddLittle(visual.id)
            writeIntLittle(visual.packedDelayHeight)
            writeByteSubtract(visual.packedRotationRefresh)
        }
    }

}
