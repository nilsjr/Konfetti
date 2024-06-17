import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.spotless)
}

//NexusConfig.PUBLISH_ARTIFACT_ID = "konfetti-core"
//apply(from = "../../scripts/publish-module.gradle.kts")

kotlin {
    jvm()

//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

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
        ktlint("1.3.0")
        target("src/**/*.kt")
    }
    java {
        removeUnusedImports()
        googleJavaFormat("1.22.0")
        target("**/*.java")
    }
}
