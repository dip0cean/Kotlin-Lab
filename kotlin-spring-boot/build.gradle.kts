import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.springframework.boot.gradle.dsl.SpringBootExtension

plugins {
    val kotlinVersion = "1.8.0"
    val springBootVersion = "3.0.1"
    val dependencyManagementVersion = "1.1.0"
    val ktlintVersion = "11.0.0"
    val asciidoctorVersion = "3.3.2"

    id("org.springframework.boot") version springBootVersion apply false
    id("io.spring.dependency-management") version dependencyManagementVersion apply false
    id("org.jlleitschuh.gradle.ktlint") version ktlintVersion apply false
    id("org.asciidoctor.jvm.convert") version asciidoctorVersion apply false

    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false
    kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
    apply {
        plugin("kotlin")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.asciidoctor.jvm.convert")
    }

    group = "com.things"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        val implementation by configurations
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib")

        val asciidoctorExt: Configuration by configurations.creating
        asciidoctorExt("org.springframework.restdocs:spring-restdocs-asciidoctor")

        val testImplementation by configurations
        testImplementation("com.ninja-squad:springmockk:4.0.0")
        testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
            exclude(module = "mockito-core")
        }

        // test - kotest
        testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
        testImplementation("io.kotest:kotest-assertions-core-jvm:5.5.4")
        testImplementation("io.kotest:kotest-extensions-jvm:5.5.4")
        testImplementation("io.kotest:kotest-property-jvm:5.5.4")

        testImplementation("com.h2database:h2")

        val compileOnly by configurations
        compileOnly("net.spy:spymemcached:2.12.3")
    }

    configure<KtlintExtension> {
        debug.set(true)
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    configure<SpringBootExtension> {
        buildInfo()
    }

    tasks {

        withType<KotlinCompile> {
            dependsOn("ktlintCheck")
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }

        withType<Test>().configureEach {
            useJUnitPlatform()
        }

        withType<AsciidoctorTask> {
            configurations("asciidoctorExt")
        }
    }
}
