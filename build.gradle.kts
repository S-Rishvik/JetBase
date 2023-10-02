// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:8.1.2")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    classpath("com.diffplug.spotless:spotless-plugin-gradle:6.20.0")
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

plugins {
  id("com.diffplug.spotless") version "6.20.0" apply false
}

subprojects {
  afterEvaluate {
    project.apply("../spotless.gradle")
  }
}