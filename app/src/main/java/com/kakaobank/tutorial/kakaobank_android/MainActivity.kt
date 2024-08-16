package com.kakaobank.tutorial.kakaobank_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kakaobank.tutorial.kakaobank_android.feature.login.LoginScreen
import com.kakaobank.tutorial.kakaobank_android.ui.theme.KakaobankandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KakaobankandroidTheme {
                LoginScreen() // LoginScreen Composable 호출

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainActivity()
}