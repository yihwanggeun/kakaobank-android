plugins {
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.hilt")
    alias(libs.plugins.org.jetbrains.kotlin.android)

}


android {
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}