package org.openrsx.protocol.login.protocol.visual.update

import org.openrsx.protocol.login.protocol.Visual

data class Hits(
    val splats: MutableList<HitSplat> = mutableListOf(),
    var self: Int = 0,
    var target: Int = 0
) : Visual {
    override fun needsReset(): Boolean {
        return splats.isNotEmpty()
    }

    override fun reset() {
        splats.clear()
        target = 0
    }
}
