plugins {
    id("kakaobank_android.android.library")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.database"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}