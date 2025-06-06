package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.PLAYER_GRAPHIC_1_MASK

class PlayerPrimaryGraphicEncoder : VisualEncoder<PlayerVisuals>(PLAYER_GRAPHIC_1_MASK) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        val visual = visuals.primaryGraphic
        writer.apply {
            writeShortAddLittle(visual.id)
            writeIntInverseMiddle(visual.packedDelayHeight)
            writeByteAdd(visual.packedRotationRefresh)
        }
    }

}
