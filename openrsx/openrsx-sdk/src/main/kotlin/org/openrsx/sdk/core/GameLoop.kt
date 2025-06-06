package org.openrsx.sdk.core

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

/**
 * Simplified game loop extracted from Void engine.
 */
class GameLoop(private val stages: List<Runnable>, private val delay: Long = 600L) {
    companion object {
        var tick: Int = 0
    }

    fun start(scope: CoroutineScope) = scope.launch {
        while (isActive) {
            val start = System.nanoTime()
            tick()
            val took = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)
            if (took < delay) {
                delay(delay - took)
            }
            tick++
        }
    }

    fun tick() {
        stages.forEach { it.run() }
    }
}
