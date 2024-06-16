plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.spotless)
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

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = 21
        targetSdk = libs.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    namespace = "nl.dionsegijn.xml.java"
    lint {
        abortOnError = true
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    implementation(project(path = ":konfetti:xml"))
    implementation(libs.androidx.appcomat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)

    debugImplementation(libs.androidx.tracing)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(libs.test.junit.ext)
}
