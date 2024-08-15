plugins {
    id("kakaobank_android.android.library")
    alias(libs.plugins.jetbrains.kotlin.android)
}


android {
    // consumerProguardFiles("consumer-rules.pro") 삭제했음 API 보호
    // proguardFiles 삭제
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.data"
}

dependencies {

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}