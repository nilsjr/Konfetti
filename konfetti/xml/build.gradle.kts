plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.spotless)
}

//NexusConfig.PUBLISH_ARTIFACT_ID = "konfetti-xml"
//apply(from = "../../scripts/publish-module.gradle.kts")

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

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        minSdk = 15
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    namespace = "nl.dionsegijn.konfetti.xml"
    lint {
        abortOnError = true
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    debugApi(project(path = ":konfetti:core"))
    releaseApi("nl.dionsegijn:konfetti-core:${libs.versions.konfettiVersion}")

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockito)
}
