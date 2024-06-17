rootProject.name = "Konfetti"

// Library modules
include(
    ":konfetti:xml",
    ":konfetti:compose",
    ":konfetti:core"
)
// Sample modules
include(
    ":samples:compose-kotlin",
    ":samples:compose-kmp",
    ":samples:xml-kotlin",
    ":samples:xml-java",
    ":samples:shared",
)

// blocked due https://github.com/gradle/gradle/issues/16608
//enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
