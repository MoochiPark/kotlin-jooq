val springBootVersion: String by project

val implementation by configurations
dependencies {
    implementation("org.springframework.boot:spring-boot-starter:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-aop:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-logging:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-parent:${springBootVersion}")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow:${springBootVersion}") {
        exclude(group = "io.undertow", module = "undertow-websockets-jsr")
    }
}