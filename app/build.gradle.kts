import nu.studer.gradle.jooq.JooqGenerate

object Configurer {
    const val databaseDriver = "org.postgresql.Driver"
    const val databaseUrl = "jdbc:postgresql://localhost:5432/test"
    const val databaseUsername = "daewon"
    const val databasePassword = "qkqh123"
    const val databaseDialect = "org.jooq.meta.postgres.PostgresDatabase"
}

plugins {
    id("nu.studer.jooq")
}

jooq {
    version.set("3.14.8")
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)
    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(true)

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.INFO
                jdbc.apply {
                    driver = Configurer.databaseDriver
                    url = Configurer.databaseUrl
                    user = Configurer.databaseUsername
                    password = Configurer.databasePassword
                    // properties.add(Property().withKey("ssl").withValue("true"))
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    strategy.apply {
                        name = "org.jooq.codegen.DefaultGeneratorStrategy"
                    }
                    database.apply {
                        name = Configurer.databaseDialect
                        inputSchema = "public"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isRelations = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "io.wisoft.seminar"
                        directory = "build/generated/jooq"
                    }
                }
            }
        }
    }
}

tasks.named<JooqGenerate>("generateJooq") {
    allInputsDeclared.set(true)
}

dependencies {
    jooqGenerator("org.postgresql:postgresql:42.2.14")
}

apply {
    from("../gradle/module/main/all-deps.gradle.kts")
    from("../gradle/module/main/spring/all-deps.gradle.kts")

    from("../gradle/module/test/all-deps.gradle.kts")
    from("../gradle/module/test/spring/all-deps.gradle.kts")
}
