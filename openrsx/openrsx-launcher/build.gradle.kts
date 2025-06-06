plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("org.openrsx.launcher.Main")
}

dependencies {
    implementation(project(":openrsx-sdk"))
    implementation(project(":openrsx-protocol-634"))
    implementation(project(":openrsx-game-634"))
    implementation(project(":openrsx-definitions-634"))
}
