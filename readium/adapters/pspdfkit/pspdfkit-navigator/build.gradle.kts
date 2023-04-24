/*
 * Copyright 2022 Readium Foundation. All rights reserved.
 * Use of this source code is governed by the BSD-style license
 * available in the top-level LICENSE file of the project.
 */

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.parcelize")
    kotlin("plugin.serialization")
}

android {
    resourcePrefix = "readium_"

    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=org.readium.r2.shared.InternalReadiumApi"
        )
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
    }
    buildFeatures {
        viewBinding = true
    }
    namespace = "org.readium.adapters.pspdfkit.navigator"
}

rootProject.ext["publish.artifactId"] = "readium-adapter-pspdfkit-navigator"
//apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    val readium_version = "2.3.0"
    implementation("org.readium.kotlin-toolkit:readium-streamer:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-navigator:$readium_version")
//    api(project(":readium:readium-shared"))
//    api(project(":readium:readium-navigator"))
    api(project(":readium:adapters:pspdfkit:readium-adapter-pspdfkit-document"))

    implementation(libs.androidx.fragment.ktx)
    implementation(libs.timber)
    implementation(libs.pspdfkit)
    implementation(libs.bundles.coroutines)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.ext.junit)
    androidTestImplementation(libs.androidx.expresso.core)
}
