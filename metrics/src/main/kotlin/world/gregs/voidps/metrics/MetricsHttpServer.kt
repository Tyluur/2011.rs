package world.gregs.voidps.metrics

import com.github.michaelbull.logging.InlineLogger
import java.net.InetSocketAddress
import com.sun.net.httpserver.HttpServer
import javax.swing.text.html.InlineView

object MetricsHttpServer {

    fun start(port: Int = 8081) {
        val server = HttpServer.create(InetSocketAddress(port), 0)
        server.createContext("/metrics") { exchange ->
            val response = Metrics.registry.scrape()
            exchange.sendResponseHeaders(200, response.toByteArray().size.toLong())
            exchange.responseBody.use { it.write(response.toByteArray()) }
        }
        server.executor = null
        server.start()

        logger.info { "📊 Metrics HTTP server started at http://localhost:$port/metrics" }
    }

}

private val logger = InlineLogger()