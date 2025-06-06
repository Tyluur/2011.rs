package org.openrsx.protocol.login.protocol.visual.encode.npc

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.NPCVisuals
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.VisualMask.NPC_COLOUR_OVERLAY_MASK

class NPCColourOverlayEncoder : VisualEncoder<NPCVisuals>(NPC_COLOUR_OVERLAY_MASK) {

    override fun encode(writer: Writer, visuals: NPCVisuals) {
        val (delay, duration, colour) = visuals.colourOverlay
        writer.apply {
            val hue = colour and 0xFF
            val saturation = colour shr 8 and 0xFF
            val luminance = colour shr 16 and 0xFF
            val multiplier = colour shr 24 and 0xFF
            writeByteInverse(hue)
            writeByteSubtract(saturation)
            writeByteInverse(luminance)
            writeByte(multiplier)
            writeShort(delay)
            writeShort(duration)
        }
    }

}
