plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.16"
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.jetpackcomposeapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jetpackcomposeapi"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.location)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //noinspection UseTomlInstead
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    //noinspection UseTomlInstead
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")


    //noinspection UseTomlInstead
    implementation("androidx.compose.material:material:1.6.6")
    //noinspection UseTomlInstead
    implementation ("com.google.android.material:material:1.11.0")

    // navigation compose
    //noinspection UseTomlInstead
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // lottie
    //noinspection UseTomlInstead
    implementation("com.airbnb.android:lottie-compose:4.0.0")

    // retrofit
    //noinspection UseTomlInstead
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //noinspection UseTomlInstead
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    //noinspection UseTomlInstead
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //noinspection UseTomlInstead
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    //noinspection UseTomlInstead
    implementation("io.coil-kt:coil-compose:2.4.0")

    //dagger-hilt
    // note that Hilt Viewmodel is now part of the main Hilt package,
    // so trying to import it with its own line causes errors
    //noinspection UseTomlInstead
    implementation("com.google.dagger:hilt-android:2.49")
    //noinspection UseTomlInstead
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.44")
    //noinspection UseTomlInstead
    ksp("com.google.dagger:hilt-compiler:2.44")
    //noinspection UseTomlInstead
    ksp("androidx.hilt:hilt-compiler:1.2.0") // 1.0.0 in course
    //noinspection UseTomlInstead
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    //noinspection UseTomlInstead
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    //hilt nav above was 1.0.0-alpha03 in vid


    // viewModel
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // Coroutines
    //noinspection UseTomlInstead
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //noinspection UseTomlInstead
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //noinspection UseTomlInstead
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    // Coil
    //noinspection UseTomlInstead
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Room
    //noinspection UseTomlInstead
    implementation ("androidx.room:room-runtime:2.6.1")
    //noinspection UseTomlInstead
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    // To use Kotlin annotation processing tool (kapt) MUST HAVE!
    // ksp("androidx.room:room-compiler:2.6.1")
    //noinspection UseTomlInstead
    implementation ("androidx.room:room-ktx:2.6.1")

    // JSON Converter
    //noinspection UseTomlInstead
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // splash api
    //noinspection UseTomlInstead
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Datastore
    //noinspection UseTomlInstead
    implementation ("androidx.datastore:datastore-preferences:1.1.0")

    //Compose Foundation
    //noinspection UseTomlInstead
    implementation ("androidx.compose.foundation:foundation:1.6.6")

    //Accompanist
    //noinspection UseTomlInstead
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    //Paging 3
    //noinspection UseTomlInstead
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    //noinspection UseTomlInstead
    implementation ("androidx.paging:paging-compose:3.3.0-beta01")
    debugImplementation("androidx.compose.material:material-icons-extended")

}