dependencies {
    implementation("io.micrometer:micrometer-core:1.15.0")                        // Core metrics facade
    implementation("io.micrometer:micrometer-registry-prometheus:1.15.0")         // Exporter for Prometheus
    implementation("com.michael-bull.kotlin-inline-logger:kotlin-inline-logger-jvm:${findProperty("inlineLoggingVersion")}")

    runtimeOnly("org.slf4j:slf4j-simple:2.0.12")
}