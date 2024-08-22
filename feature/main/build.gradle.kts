plugins {
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.library.compose")
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android"
}
dependencies {
    implementation(project(":core:designsystem"))
}

