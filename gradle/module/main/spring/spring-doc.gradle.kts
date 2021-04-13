val springDocOpenApiVersion: String by project

val implementation by configurations
dependencies {
    implementation("org.springdoc:springdoc-openapi-kotlin:${springDocOpenApiVersion}")
    implementation("org.springdoc:springdoc-openapi-webmvc-core:${springDocOpenApiVersion}")
    implementation("org.springdoc:springdoc-openapi-ui:${springDocOpenApiVersion}")
}