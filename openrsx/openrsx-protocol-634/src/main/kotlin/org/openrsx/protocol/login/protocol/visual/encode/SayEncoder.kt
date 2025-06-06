package org.openrsx.protocol.login.protocol.visual.encode

import world.gregs.voidps.buffer.write.Writer
import org.openrsx.protocol.login.protocol.visual.VisualEncoder
import org.openrsx.protocol.login.protocol.visual.Visuals

class SayEncoder(mask: Int) : VisualEncoder<Visuals>(mask) {

    override fun encode(writer: Writer, visuals: Visuals) {
        writer.writeString(visuals.say.text)
    }

}
