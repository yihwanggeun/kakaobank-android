package com.kakaobank.tutorial.kakaobank_android.feature.transfer

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

object TransferRoute {
    const val route = "transfer"
    const val detailRoute = "transfer/detail"
}

fun NavGraphBuilder.transferNavGraph(navController: NavController) {
    navigation(startDestination = TransferRoute.route, route = "transfer_flow") {
        composable(route = TransferRoute.route) {
            TransferScreen(
                onNavigateToDetail = { navController.navigate(TransferRoute.detailRoute) }
            )
        }
        composable(route = TransferRoute.detailRoute) {
            TransferDetailScreen()
        }
    }
}