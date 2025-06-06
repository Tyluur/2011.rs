package org.openrsx.sdk.core

/**
 * Very small world scheduler used by the engine.
 */
object World : Runnable {
    private val actions = mutableListOf<() -> Unit>()

    fun queue(action: () -> Unit) {
        actions += action
    }

    override fun run() {
        val iterator = actions.iterator()
        while (iterator.hasNext()) {
            val action = iterator.next()
            iterator.remove()
            action.invoke()
        }
    }
}
