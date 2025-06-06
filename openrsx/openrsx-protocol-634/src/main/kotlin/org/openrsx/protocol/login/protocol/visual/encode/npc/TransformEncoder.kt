package org.openrsx.protocol.login.protocol.visual.encode.npc

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.NPCVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.TRANSFORM_MASK

class TransformEncoder : VisualEncoder<NPCVisuals>(TRANSFORM_MASK, initial = true) {

    override fun encode(writer: Writer, visuals: NPCVisuals) {
        writer.writeShortAdd(visuals.transform.id)
    }

}
