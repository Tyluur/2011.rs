package org.openrsx.protocol.login.protocol.visual

import org.openrsx.protocol.login.protocol.visual.update.npc.Transformation

class NPCVisuals() : Visuals() {

    val transform = Transformation()

    override fun reset() {
        super.reset()
        transform.clear()
    }
}
