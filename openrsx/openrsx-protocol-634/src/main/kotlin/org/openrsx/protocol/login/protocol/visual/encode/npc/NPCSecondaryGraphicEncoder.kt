package org.openrsx.protocol.login.protocol.visual.encode.npc

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.NPCVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.NPC_GRAPHIC_2_MASK

class NPCSecondaryGraphicEncoder : VisualEncoder<NPCVisuals>(NPC_GRAPHIC_2_MASK) {

    override fun encode(writer: Writer, visuals: NPCVisuals) {
        val visual = visuals.secondaryGraphic
        writer.apply {
            writeShortLittle(visual.id)
            writeIntLittle(visual.packedDelayHeight)
            writeByteSubtract(visual.packedRotationRefresh)
        }
    }

}
