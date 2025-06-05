package world.gregs.voidps.metrics

import io.micrometer.core.instrument.binder.jvm.*
import io.micrometer.core.instrument.binder.system.ProcessorMetrics
import io.micrometer.prometheusmetrics.PrometheusConfig
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry
import java.util.concurrent.atomic.AtomicInteger

object Metrics {
    val registry: PrometheusMeterRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

    val onlinePlayers = AtomicInteger(0)

    init {
        ClassLoaderMetrics().bindTo(registry)
        JvmMemoryMetrics().bindTo(registry)
        JvmGcMetrics().bindTo(registry)
        ProcessorMetrics().bindTo(registry)
        JvmThreadMetrics().bindTo(registry)

        registry.gauge("void.players.online", onlinePlayers)
    }

    fun setOnlinePlayerCount(count: Int) {
        onlinePlayers.set(count)
    }
}
