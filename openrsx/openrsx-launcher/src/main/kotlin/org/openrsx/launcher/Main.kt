package org.openrsx.launcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.openrsx.definitions634.DefinitionLoader
import org.openrsx.game634.GameLogic
import org.openrsx.protocol634.GameServer
import org.openrsx.sdk.core.GameLoop
import org.openrsx.sdk.core.World

/**
 * Simple entry point bootstrapping the engine with 634 modules.
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        DefinitionLoader.load()
        GameLogic.init()

        val stages = listOf(World)
        val loop = GameLoop(stages)
        val scope = CoroutineScope(Dispatchers.Default)
        loop.start(scope)

        val server = GameServer()
        server.start(43594)
    }
}
