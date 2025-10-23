rootProject.name = "core-conventions"

pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/helpscout/*")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull ?: System.getenv("HS_GITHUB_PACKAGES_USER")
                password = providers.gradleProperty("gpr.key").orNull ?: System.getenv("HS_GITHUB_PACKAGES_TOKEN")
            }
        }
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}