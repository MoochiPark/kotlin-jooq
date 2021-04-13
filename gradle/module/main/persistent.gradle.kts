val jooqVersion: String by project
val postgresVersion: String by project

val implementation by configurations
dependencies {
    implementation("org.jooq:jooq:${jooqVersion}")
    implementation("org.postgresql:postgresql:${postgresVersion}")
}