val assertjVersion: String by project

val testImplementation by configurations
dependencies {
    testImplementation("org.assertj:assertj-core:${assertjVersion}")
}