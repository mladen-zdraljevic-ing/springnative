// see https://docs.gradle.org/current/samples/sample_convention_plugins.html
plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    maven {
        url = uri("https://maven.pkg.github.com/helpscout/*")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("HS_GITHUB_PACKAGES_USER")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("HS_GITHUB_PACKAGES_TOKEN")
        }
    }
}

dependencies {
    implementation(enforcedPlatform(libs.hs.backend.platform))
    implementation("helpscout.gradle.conventions:gradle-convention-plugins")
//    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.noarg.plugin)
}

kotlin {
    jvmToolchain(21)
}
