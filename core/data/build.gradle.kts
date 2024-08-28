plugins {
    id("kakaobank_android.android.library")
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("kakaobank_android.android.hilt")
}


android {
    // consumerProguardFiles("consumer-rules.pro") 삭제했음 API 보호
    // proguardFiles 삭제
    namespace = "com.kakaobank.tutorial.kakaobank_android.core.data"
}

dependencies {
    // Retrofit
    implementation (libs.retrofit)

    // Retrofit과 함께 사용할 JSON 변환 라이브러리
    implementation (libs.converter.gson)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}