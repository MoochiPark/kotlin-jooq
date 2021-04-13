val logbackVersion: String by project
val slf4jVersion: String by project

val implementation by configurations
dependencies {
    implementation("ch.qos.logback:logback-classic:${logbackVersion}")
    implementation("ch.qos.logback:logback-core:${logbackVersion}")

    implementation("org.slf4j:jcl-over-slf4j:${slf4jVersion}")
    implementation("org.slf4j:jul-to-slf4j:${slf4jVersion}")
    implementation("org.slf4j:log4j-over-slf4j:${slf4jVersion}")
    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
}