plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "br.com.mdr.petcare"
version = "1.0.0"
application {
    mainClass.set("br.com.mdr.petcare.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.mongodb.kotlin.driver)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}