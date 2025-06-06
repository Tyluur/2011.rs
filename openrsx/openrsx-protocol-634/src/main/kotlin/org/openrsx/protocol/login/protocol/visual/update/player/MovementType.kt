package org.openrsx.protocol.login.protocol.visual.update.player

import org.openrsx.protocol.login.protocol.Visual

data class MovementType(var type: MoveType = MoveType.None) : Visual {
    override fun needsReset(): Boolean {
        return type != MoveType.None
    }

    override fun reset() {
        type = MoveType.None
    }
}
