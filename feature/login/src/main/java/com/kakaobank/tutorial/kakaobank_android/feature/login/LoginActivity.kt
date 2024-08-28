package com.kakaobank.tutorial.kakaobank_android.feature.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaobankandroidTheme
import com.kakaobank.tutorial.kakaobank_android.feature.main.MainRoute
import com.kakaobank.tutorial.kakaobank_android.feature.main.MainScreen
import com.kakaobank.tutorial.kakaobank_android.feature.main.mainNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KakaobankandroidTheme {
                val navController = rememberNavController()

                Surface(color = MaterialTheme.colorScheme.background){
                    AppNavigation()
                }

            }
        }
    }
}