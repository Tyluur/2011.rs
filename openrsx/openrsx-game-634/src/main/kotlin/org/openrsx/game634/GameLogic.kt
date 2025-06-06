package org.openrsx.game634

import org.openrsx.sdk.core.World

/**
 * Example game logic for revision 634.
 */
object GameLogic {
    fun init() {
        World.queue { println("Game logic tick") }
    }
}
