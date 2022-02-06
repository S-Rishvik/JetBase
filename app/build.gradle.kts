plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.example.jetbase"
    minSdk = 21
    targetSdk = 31
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt") , "proguard-rules.pro")
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
    compose=true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
    kotlinCompilerVersion = "1.5.21"
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(project(":domain"))
  implementation(project(":data"))

  //Kotlin
  implementation(Lib.Kotlin.KTX_CORE)

  //Android
  implementation(Lib.Android.APP_COMPAT)
  implementation(Lib.Android.MATERIAL_DESIGN)
  implementation(Lib.Android.COMPOSE_UI)
  implementation(Lib.Android.COMPOSE_MATERIAL_DESIGN)
  implementation(Lib.Android.UI_TOOLING_PREVIEW)
  implementation(Lib.Android.LIFECYCLE_RUNTIME_KTX)
  implementation(Lib.Android.ACTIVITY_COMPOSE)

  implementation("com.jakewharton.timber:timber:5.0.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt")

  //Test
  testImplementation(Lib.TestLib.JUNIT)
  androidTestImplementation(Lib.TestLib.ANDROID_JUNIT)
  androidTestImplementation(Lib.TestLib.ESPRESSO_CORE)
  androidTestImplementation(Lib.TestLib.UI_TEST_JUNIT)
  debugImplementation(Lib.TestLib.UI_TOOLING)
}