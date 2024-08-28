package com.kakaobank.tutorial.kakobank_android

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureHiltKotlin(
    commonExtension: CommonExtension<*, *, *, *>,
){
    pluginManager.apply("org.jetbrains.kotlin.kapt")
    dependencies {
        add("implementation", libs.findLibrary("hilt-core").get())
        add("kapt", libs.findLibrary("hilt-compiler").get())
    }
}
