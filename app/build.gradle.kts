plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.jetbase"
        minSdk = 24
        targetSdk = 33
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
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.example.jetbase"
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    //Kotlin
    implementation(Lib.Kotlin.KTX_CORE)

    //Android
    implementation(Lib.Android.APP_COMPAT)
    implementation(platform(Lib.Android.COMPOSE_BOM))
    implementation(Lib.Android.COMPOSE_UI)
    implementation(Lib.Android.COMPOSE_MATERIAL_DESIGN)
    implementation(Lib.Android.UI_TOOLING_PREVIEW)
    implementation(Lib.Android.LIFECYCLE_RUNTIME_KTX)
    implementation(Lib.Android.ACTIVITY_COMPOSE)
    implementation(Lib.Android.TIMBER)
    implementation(Lib.Android.COROUTINES_ANDROID)
    implementation(Lib.Kotlin.COIL)
    implementation(Lib.Android.HILT)
    ksp(Lib.Android.HILT_COMPILER)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.google.code.gson:gson:2.8.9")

    //Test
    testImplementation(Lib.TestLib.JUNIT)
    androidTestImplementation(Lib.TestLib.ANDROID_JUNIT)
    androidTestImplementation(Lib.TestLib.ESPRESSO_CORE)
    androidTestImplementation(platform(Lib.Android.COMPOSE_BOM))
    androidTestImplementation(Lib.TestLib.UI_TEST_JUNIT)
    debugImplementation(Lib.TestLib.UI_TOOLING)
}