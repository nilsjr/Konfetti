plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("com.diffplug.spotless")
}

//NexusConfig.PUBLISH_ARTIFACT_ID = "konfetti-core"
//apply(from = "../../scripts/publish-module.gradle.kts")

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

spotless {
    kotlin {
        ktlint("1.1.0")
        target("src/**/*.kt")
    }
    java {
        removeUnusedImports()
        googleJavaFormat("1.22.0")
        target("**/*.java")
    }
}
