plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

group = "org.ksystem.app"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(libs.kotlin.datetime)
    implementation(libs.kotlin.collections)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.coroutines)

    implementation(libs.ktor.core)
    implementation(libs.ktor.netty)
    implementation(libs.ktor.config)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.contentNegotiation)
    implementation(libs.ktor.resources)
    implementation(libs.ktor.statusPages)
    implementation(libs.ktor.auth)
    implementation(libs.ktor.authJwt)
    implementation(libs.ktor.websockets)
    implementation(libs.ktor.callLoging)

    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.coroutines)

    implementation(libs.jwt)

    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.datetime)
    implementation(libs.mysqlConnector)
    implementation(libs.hikariCP)

    implementation(libs.log4j.core)
    implementation(libs.log4j.impl)
}