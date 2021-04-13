val pemKeystoreVersion: String by project

val implementation by configurations
dependencies {
    implementation("de.dentrassi.crypto:pem-keystore:${pemKeystoreVersion}")
}