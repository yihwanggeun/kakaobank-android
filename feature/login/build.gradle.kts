plugins {
    id("kakaobank_android.android.library.compose")
    id("kakaobank_android.android.library")
}

android {
    namespace = "com.kakaobank.tutorial.kakaobank_android.feature.login"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

}

