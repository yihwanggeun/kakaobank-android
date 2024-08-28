plugins {
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.library.compose")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.designsystem"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}