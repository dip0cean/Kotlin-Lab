import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":module-domain")) // domain project setting 1
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation(testFixtures(project(":module-domain")))
}

tasks {
    // Spring REST Docs
    val snippetsDir = file("build/generated-snippets")

    withType<Test> {
        outputs.dir(snippetsDir)
        filter {
            includeTestsMatching("com.study.kotlin")
        }
    }

    withType<AsciidoctorTask> {
        inputs.dir(snippetsDir)
        dependsOn(test)
        doFirst {
            delete {
                file("build/docs/asciidoc")
                file("src/main/resources/static/docs")
            }
        }
    }

    withType<BootJar> {
        dependsOn(asciidoctor)
        from("${asciidoctor.get().outputDir}/html5") {
            into("static/docs")
        }

        // BootJar 파일명
        archiveBaseName.set("api")
        // BootJar 버전
        archiveVersion.set("")
    }

    val copyDocument by registering(Copy::class) {
        dependsOn(asciidoctor)

        from(file("build/docs/asciidoc/"))
        into(file("src/main/resources/static/docs"))
    }

    build {
        dependsOn(copyDocument)
    }
}
