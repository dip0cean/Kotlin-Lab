import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java-test-fixtures")
    id("maven-publish")
    id("java-library")
    kotlin("kapt")
    kotlin("plugin.jpa")
    kotlin("plugin.serialization")
}

// All Open Setting 1
allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    val kapt by configurations
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-jpa:5.0.0:jakarta")

    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.1")
    implementation("com.eaio.uuid:uuid:3.2")

    runtimeOnly("com.mysql:mysql-connector-j")

    testFixturesImplementation("com.ninja-squad:springmockk:4.0.0")
    testFixturesImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testFixturesImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
    testFixturesImplementation("io.kotest:kotest-assertions-core-jvm:5.5.4")
    testFixturesImplementation("io.kotest:kotest-extensions-jvm:5.5.4")
    testFixturesImplementation("io.kotest:kotest-property-jvm:5.5.4")
}

tasks {
    withType<Jar> {
        enabled = true
    }

    withType<BootJar> {
        enabled = false
    }
}
