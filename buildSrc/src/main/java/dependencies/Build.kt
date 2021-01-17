package dependencies

object Build {
    val build_tools = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val google_services = "com.google.gms:google-services:${Versions.play_services}"
    val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:1.3.2.0"
    val fabric = "io.fabric.tools:gradle:${Versions.fabric_version}"
    val hilt_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}"
    val navigation_component_safe_arg = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_component_version}"
}