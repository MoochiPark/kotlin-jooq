val mockitoVersion: String by project

val testImplementation by configurations
dependencies {
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
    testImplementation("org.mockito:mockito-junit-jupiter:${mockitoVersion}")
}