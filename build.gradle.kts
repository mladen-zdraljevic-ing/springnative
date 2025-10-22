
plugins {
    id("net.helpscout.core.jvm-conventions")
    id("hs-openapi-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
    id("org.graalvm.buildtools.native") version "0.10.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "springnative"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/helpscout/*")
        credentials {
            username = providers.gradleProperty("gpr.user").orNull ?: System.getenv("HS_GITHUB_PACKAGES_USER")
            password = providers.gradleProperty("gpr.key").orNull ?: System.getenv("HS_GITHUB_PACKAGES_TOKEN")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}