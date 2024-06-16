plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.android.maven.gradle) apply false
    alias(libs.plugins.github.gradle.nexus.publish)
    alias(libs.plugins.jetbrains.dokka)
}

// Connect with the repository using properties from local.properties in the root of the project
val properties = File(rootDir, "local.properties")
if (properties.exists()) {
    val localProperties = properties.inputStream().use { java.util.Properties().apply { load(it) } }
    // Set up Sonatype repository
    nexusPublishing {
        repositories {
            sonatype {
                stagingProfileId.set(localProperties["sonatypeStagingProfileId"] as String?)
                username.set(localProperties["ossrhUsername"] as String?)
                password.set(localProperties["ossrhPassword"] as String?)
            }
        }
    }
}

/**
 * TODO:
 * - toml finish
 * - core tests
 * - sample ios, wasm
 * - update deps
 */
