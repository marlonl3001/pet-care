import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.jetbrainsCompose)
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
       browser()
    }
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    jvm()
    
    sourceSets {
        val commonMain by getting
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val androidMain by getting {
            dependsOn(commonMain)
        }
        commonMain.dependencies {
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.moko.mvvm.compose)
            api(libs.androidx.datastore.preferences.core)
            api(libs.androidx.datastore.core.okio)

            api(libs.moko.mvvm.core)
            api(libs.moko.resources)
            api(libs.moko.resources.compose)
            api(libs.koin.core)
            api(libs.koin.test)
        }
    }
}

android {
    namespace = "br.com.mdr.petcare.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "br.com.mdr.petcare.shared" // required
}
