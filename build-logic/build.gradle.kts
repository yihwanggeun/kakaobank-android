plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins{
        register("androidLibrary"){
            id = "kakaobank_android.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidLibraryCompose"){
            id = "kakaobank_android.android.library.compose"
            implementationClass = "AndroidLibraryComposePlugin"
        }
    }
}