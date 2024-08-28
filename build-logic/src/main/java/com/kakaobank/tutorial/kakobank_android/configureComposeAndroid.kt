package com.kakaobank.tutorial.kakobank_android

import com.android.build.api.dsl.CommonExtension
import com.github.javaparser.utils.Log
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
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
        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("implementation", libs.findLibrary("hilt-navigation-compose").get())
            add("implementation", libs.findLibrary("androidx-ui").get())
            add("implementation", libs.findLibrary("androidx-ui-graphics").get())
            add("implementation", libs.findLibrary("androidx-ui-tooling").get())
            add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())
            add("implementation", libs.findLibrary("androidx-material3").get())
            add("implementation", libs.findLibrary("androidx-activity-compose").get())
            add("implementation",libs.findLibrary("androidx-navigation-compose").get())
            add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
            add("androidTestImplementation", platform(bom))
            add(
                "androidTestImplementation",
                libs.findLibrary("androidx-ui-test-junit4").get()
            )
            add("debugImplementation", libs.findLibrary("androidx-ui-test-manifest").get())


        }


    }


}