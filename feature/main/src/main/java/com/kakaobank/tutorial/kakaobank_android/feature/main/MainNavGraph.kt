package com.kakaobank.tutorial.kakaobank_android.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

object MainRoute {
    const val route = "main"
}

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    composable(route = MainRoute.route) {
        MainScreen(navController)
    }
}