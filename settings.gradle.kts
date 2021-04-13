// plugin management 추가
pluginManagement {
    val kotlinVersion: String by settings // gradle.properties에서 불러옴
    val springBootVersion: String by settings
    val springDependencyManagement: String by settings

    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagement
    }
}

rootProject.name = "kotlin-jooq"
include("app")
