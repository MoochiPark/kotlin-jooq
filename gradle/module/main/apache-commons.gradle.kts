// settings가 아닌 project에서 가져온다.
val commonsCodecVersion: String by project
val commonsLang3Version: String by project
val commonsPool2Version: String by project

val implementation by configurations
dependencies {
    implementation("commons-codec:commons-codec:${commonsCodecVersion}")
    implementation("org.apache.commons:commons-lang3:${commonsLang3Version}")
    implementation("org.apache.commons:commons-pool2:${commonsPool2Version}")
}