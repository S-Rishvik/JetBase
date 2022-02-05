object BuildPlugins {

}

object Lib {

  object Android {
    const val COMPOSE_VERSION = "1.0.1"
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
    const val MATERIAL_DESIGN = "com.google.android.material:material:1.4.0"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL_DESIGN = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.3.0-alpha06"
  }

  object Kotlin {
    const val KTX_CORE_VERSION = "1.2.0"
    const val COROUTINES_VERSION = "1.3.7"

    const val KTX_CORE = "androidx.core:core-ktx:${KTX_CORE_VERSION}"
    const val COROUTINES =
      "org.jetbrains.kotlinx:kotlinx-coroutines-core:${COROUTINES_VERSION}"
    const val COROUTINES_ANDROID =
      "org.jetbrains.kotlinx:kotlinx-coroutines-android:${COROUTINES_VERSION}"
    const val COROUTINES_PLAY_SERVICES =
      "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.9"
  }

  object TestLib {
    const val COMPOSE_VERSION = "1.0.1"
    const val JUNIT = "junit:junit:4.+"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
  }
}