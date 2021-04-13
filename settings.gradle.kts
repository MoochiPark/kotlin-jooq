// plugin management 추가
pluginManagement {
    val kotlinVersion: String by settings // gradle.properties에서 불러옴

    val ktLintPluginVersion: String by settings
    val detektPluginVersion: String by settings

    val jooqPluginVersion: String by settings
    val flywayPluginVersion: String by settings
    val johnrengelmanProcessPluginVersion: String by settings

    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val springDocPluginVersion: String by settings

    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
        id("org.jlleitschuh.gradle.ktlint") version ktLintPluginVersion
        id("io.gitlab.arturbosch.detekt") version detektPluginVersion

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        id("org.springdoc.openapi-gradle-plugin") version springDocPluginVersion

        id("nu.studer.jooq") version jooqPluginVersion
        id("org.flywaydb.flyway") version flywayPluginVersion
        id("com.github.johnrengelman.processes") version johnrengelmanProcessPluginVersion
    }
}

rootProject.name = "kotlin-jooq"
include("app")
