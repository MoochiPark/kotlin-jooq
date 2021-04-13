import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")

    id("nu.studer.jooq") apply false
    id("org.flywaydb.flyway") apply false
    id("com.github.johnrengelman.processes") apply false

    id("org.jetbrains.kotlin.plugin.spring") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
    id("org.springdoc.openapi-gradle-plugin") apply false
}

allprojects {
    group = "io.wisoft.seminar"
    version = "2021.14.0"
    repositories {
        maven {
            url = uri("https://nexus.wisoft.io/repository/maven-public/")
            credentials {
                username = "readonly"
                password = "hQUNp6m9yKnGK58D"
            }
        }

        google()
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("io.gitlab.arturbosch.detekt")

        plugin("nu.studer.jooq")
        plugin("org.flywaydb.flyway")
        plugin("com.github.johnrengelman.processes")

        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.springdoc.openapi-gradle-plugin")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            useIR = true
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "7.0"
    distributionType = Wrapper.DistributionType.BIN
}
