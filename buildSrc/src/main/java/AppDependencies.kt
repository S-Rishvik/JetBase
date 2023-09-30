import Versions.COMPOSE_BOM
import Versions.COMPOSE_VERSION

object BuildPlugins {

}

object Lib {

    object Android {
        const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
        const val MATERIAL_DESIGN = "com.google.android.material:material:1.4.0"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
        const val COMPOSE_MATERIAL_DESIGN = "androidx.compose.material:material"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose"
        const val TIMBER = "com.jakewharton.timber:timber:5.0.1"
    }

    object Kotlin {
        const val KTX_CORE = "androidx.core:core-ktx:${Versions.KTX_CORE_VERSION}"
        const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
        const val COROUTINES_PLAY_SERVICES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.9"
        const val COIL = "io.coil-kt:coil-compose:1.4.0"
    }

    object TestLib {
        const val JUNIT = "junit:junit:4.+"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:1.1.3"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
        const val UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling"
    }
}