val typesafeConfigVersion: String by project

val implementation by configurations
dependencies {
    implementation("com.typesafe:config:${typesafeConfigVersion}")
}