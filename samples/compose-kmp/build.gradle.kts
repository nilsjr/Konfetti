import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    jvmToolchain(17)

    jvm("desktop")

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":konfetti:compose"))
                implementation(project(":samples:shared"))
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.preview)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose {
    desktop {
        application {
            mainClass = "MainKt"
            nativeDistributions {
                targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = "de.nilsdruyen.cheetah"
                packageVersion = "1.0.0"
            }
        }
    }
}