package com.kakaobank.tutorial.kakobank_android

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid(
    commonExtension: CommonExtension<*, *, *, *>,
){
    dependencies {
        add("implementation", libs.findLibrary("hilt-core").get())
        add("kapt", libs.findLibrary("hilt-compiler").get())
        add("kaptAndroidTest", libs.findLibrary("hilt-android-compiler").get())

    }
}
