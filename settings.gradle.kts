rootProject.name = "springnative"

buildscript {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/helpscout/*")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull ?: System.getenv("HS_GITHUB_PACKAGES_USER")
                password = providers.gradleProperty("gpr.key").orNull ?: System.getenv("HS_GITHUB_PACKAGES_TOKEN")
            }
        }
        gradlePluginPortal()
    }
    dependencies {
        classpath(enforcedPlatform("helpscout:hs-backend-platform:4.4.0"))
        classpath("helpscout.gradle.conventions:gradle-convention-plugins")
    }
}

plugins.apply("hs-openapi-settings")