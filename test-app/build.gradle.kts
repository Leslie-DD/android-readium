/*
 * Copyright 2021 Readium Foundation. All rights reserved.
 * Use of this source code is governed by the BSD-style license
 * available in the top-level LICENSE file of the project.
 */

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.parcelize")
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33

        applicationId = "org.readium.r2reader"

        versionName = "2.3.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk.abiFilters.add("armeabi-v7a")
        ndk.abiFilters.add("arm64-v8a")
        ndk.abiFilters.add("x86")
        ndk.abiFilters.add("x86_64")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            res.srcDirs("src/main/res")
            assets.srcDirs("src/main/assets")
        }
    }
    namespace = "org.readium.r2.testapp"
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.legacy.v4)
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")

    val readium_version = "2.3.0"
    implementation("org.readium.kotlin-toolkit:readium-shared:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-streamer:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-navigator:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-navigator-media2:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-opds:$readium_version")
    implementation("org.readium.kotlin-toolkit:readium-lcp:$readium_version")
    // Only required if you want to support PDF files using PDFium.
    implementation(project(":readium:adapters:pdfium"))

//    implementation("io.coil-kt:coil-compose:2.3.0")
    implementation("io.coil-kt:coil-compose:2.2.2")


    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.cardview)

    implementation(libs.bundles.compose)
//    debugImplementation(libs.androidx.compose.ui)

    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.bundles.lifecycle)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.paging)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.webkit)
    implementation(libs.google.material)
    implementation(libs.timber)
    implementation(libs.picasso)
    implementation(libs.joda.time)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.jsoup)

    implementation(libs.bundles.media2)

    // Room database
    implementation(libs.bundles.room)
    kapt(libs.androidx.room.compiler)

    // Tests
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.ext.junit)
    androidTestImplementation(libs.androidx.expresso.core)
}
