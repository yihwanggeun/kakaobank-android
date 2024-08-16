package com.kakaobank.tutorial.kakaobank_android.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kakaobank.tutorial.kakaobank_android.feature.main.ui.theme.KakaobankandroidTheme

@Composable
fun MainScreen() {

    KakaobankandroidTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.Red)) {
            Greeting(
                name = "Android"
            )
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KakaobankandroidTheme {
        Greeting("Android")
    }
}