plugins {
  id("com.android.application") version "8.1.0" apply false
  id("com.android.library") version("8.0.1") apply false
  id("org.jetbrains.kotlin.android") version "1.9.10" apply false
  id("com.diffplug.spotless") version "6.20.0" apply false
  id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
  id("com.google.dagger.hilt.android") version "2.48" apply false
}

apply(from = "spotless.gradle")