plugins {
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.library.compose")
}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android"
}

dependencies {
    implementation(project(":core:designsystem"))
}
