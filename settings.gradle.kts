rootProject.name = "Konfetti"
//enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

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
