plugins {
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.library.compose")
    id("kakaobank_android.android.hilt")

}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:data"))
    implementation(project(":core:data"))
    implementation(libs.androidx.runtime.livedata)
}