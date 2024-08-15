plugins {
    id("kakaobank_android.android.library")
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.designsystem"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}