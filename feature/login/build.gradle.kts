import java.util.Properties

plugins {
    id("kakaobank_android.android.library.compose")
    id("kakaobank_android.android.library")
    id("kakaobank_android.android.hilt")
    alias(libs.plugins.org.jetbrains.kotlin.android)
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

        buildConfigField(
            "String",
            "KAKAO_NATIVE_APP_KEY",
            "\"${getLocalProperty("kakao_native_app_key", project)}\""
        )
        manifestPlaceholders["KAKAO_NATIVE_APP_KEY"] = getLocalProperty("kakao_native_app_key", project)

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true  // BuildConfig 생성 기능 활성화
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":feature:transfer"))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation ("com.kakao.sdk:v2-all:2.20.1") // 전체 모듈 설치, 2.11.0 버전부터 지원
    implementation( "com.kakao.sdk:v2-user:2.20.1" )// 카카오 로그인 API 모듈
    implementation ("com.kakao.sdk:v2-share:2.20.1") // 카카오톡 공유 API 모듈
    implementation ("com.kakao.sdk:v2-talk:2.20.1") // 카카오톡 채널, 카카오톡 소셜, 카카오톡 메시지 API 모듈
    implementation ("com.kakao.sdk:v2-friend:2.20.1") // 피커 API 모듈
    implementation ("com.kakao.sdk:v2-navi:2.20.1") // 카카오내비 API 모듈
    implementation ("com.kakao.sdk:v2-cert:2.20.1") // 카카오톡 인증 서비스 API 모듈

    implementation(project(":core:designsystem"))
    implementation(project(":feature:main"))
}


fun getLocalProperty(propertyName: String, project: Project): String {
    val propertiesFile = File(project.rootDir, "local.properties")
    if (propertiesFile.exists()) {
        val properties = Properties()
        properties.load(propertiesFile.inputStream())
        return properties.getProperty(propertyName)
    }
    throw IllegalStateException("Property $propertyName not found in local.properties")
}
