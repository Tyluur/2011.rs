package org.openrsx.protocol.login.protocol.visual.encode.npc

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.NPCVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.NPC_ANIMATION_MASK

class NPCAnimationEncoder : VisualEncoder<NPCVisuals>(NPC_ANIMATION_MASK) {

    override fun encode(writer: Writer, visuals: NPCVisuals) {
        val (first, second, third, fourth, delay) = visuals.animation
        writer.apply {
            writeShort(first)
            writeShort(second)
            writeShort(third)
            writeShort(fourth)
            writeByteSubtract(delay)
        }
    }
}
