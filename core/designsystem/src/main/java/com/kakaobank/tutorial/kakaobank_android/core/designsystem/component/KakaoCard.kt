package com.kakaobank.tutorial.kakaobank_android.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoYellow

@Composable
fun KakaoCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background,
    content: @Composable () -> Unit
    ){
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = color,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(16.dp),
        content = content,

        )
}


@Composable
fun KakaoWidthCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background,
    content: @Composable () -> Unit
    )
    {
    Surface (
        modifier = modifier,
        color = color,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(16.dp),
        content = content,
    )
}