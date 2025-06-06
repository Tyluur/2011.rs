package org.openrsx.protocol.login.protocol.visual.encode.player

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.PlayerVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.MOVEMENT_TYPE_MASK

class MovementTypeEncoder : VisualEncoder<PlayerVisuals>(MOVEMENT_TYPE_MASK, initial = true) {

    override fun encode(writer: Writer, visuals: PlayerVisuals) {
        writer.writeByteInverse(visuals.movementType.type.id)
    }

}
