package com.kakaobank.tutorial.kakaobank_android.feature.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object LoginRoute {
    const val route = "login"
}

fun NavGraphBuilder.loginNavGraph(onLoginSuccess: () -> Unit) {
    composable(route = LoginRoute.route) {
        LoginScreen(onLoginSuccess = onLoginSuccess)
    }
}