import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// 플러그인 삽입
// jvm, spirng, springboot
plugins {
    id("org.jetbrains.kotlin.jvm")

    id("org.jetbrains.kotlin.plugin.spring") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
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

        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
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