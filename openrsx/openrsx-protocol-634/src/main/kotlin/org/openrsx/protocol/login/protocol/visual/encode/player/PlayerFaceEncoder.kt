package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.PLAYER_FACE_MASK

class PlayerFaceEncoder : VisualEncoder<PlayerVisuals>(PLAYER_FACE_MASK, initial = true) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        writer.writeShort(visuals.face.direction)
    }

}
