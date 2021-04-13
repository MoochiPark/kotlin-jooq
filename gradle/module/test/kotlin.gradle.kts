val kotlinVersion: String by project

val testImplementation by configurations
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:${kotlinVersion}")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${kotlinVersion}") {
        exclude(group = "junit", module = "junit")
    }
}
