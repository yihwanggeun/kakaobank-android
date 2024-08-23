pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://devrepo.kakao.com/nexus/content/groups/public/") }

    }
}

rootProject.name = "kakaobank-android"
include(":app")
include(":core:domain")
include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":core:model")
include(":feature:login")
include(":feature:main")
include(":feature:home")
include(":feature:transfer")
