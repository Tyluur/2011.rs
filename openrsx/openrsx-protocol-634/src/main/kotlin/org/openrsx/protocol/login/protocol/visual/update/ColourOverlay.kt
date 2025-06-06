package org.openrsx.protocol.login.protocol.visual.update

import org.openrsx.protocol.login.protocol.Visual

data class ColourOverlay(
    var delay: Int = 0,
    var duration: Int = 0,
    var colour: Int = 0
) : Visual {
    override fun reset() {
        delay = 0
        duration = 0
        colour = 0
    }
}
