package org.openrsx.protocol.login.protocol.visual.update

import org.openrsx.protocol.login.protocol.Visual

data class Say(var text: String = "") : Visual {
    override fun needsReset(): Boolean {
        return text.isNotEmpty()
    }

    override fun reset() {
        text = ""
    }
}
