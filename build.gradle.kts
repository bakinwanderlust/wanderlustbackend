val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("io.ktor.plugin") version "2.1.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

group = "de.wanderlustapps"
version = "0.0.1"
application {
    mainClass.set("de.wanderlustapps.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Exposed
    implementation("org.jetbrains.exposed:exposed-core:0.39.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.39.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.39.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.39.1")

    // MySql
    implementation("mysql:mysql-connector-java:8.0.30")


    // Koin
    implementation("io.insert-koin:koin-ktor:3.2.0")

    // Kotlin Serialization
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
}