package com.kakaobank.tutorial.kakaobank_android.feature.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.feature.main.MainRoute
import com.kakaobank.tutorial.kakaobank_android.feature.main.mainNavGraph
import com.kakaobank.tutorial.kakaobank_android.feature.transfer.transferNavGraph

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LoginRoute.route) {
        loginNavGraph(
            onLoginSuccess = {
                navController.navigate(MainRoute.route) {
                    popUpTo(LoginRoute.route) { inclusive = true }
                }
            }
        )
        mainNavGraph(navController)
        transferNavGraph(navController)
    }
}