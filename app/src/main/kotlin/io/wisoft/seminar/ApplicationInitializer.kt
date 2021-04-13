package io.wisoft.seminar

import de.dentrassi.crypto.pem.PemKeyStoreProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.security.Security

@SpringBootApplication
class ApplicationInitializer

fun main(args: Array<String>) {
    // Pem키를 위한 설정
    Security.addProvider(PemKeyStoreProvider())
    runApplication<ApplicationInitializer>(*args)
}
