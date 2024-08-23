package com.kakaobank.tutorial.kakaobank_android.feature.transfer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.R
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBlack
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoYellow
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaobankandroidTheme
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.appleSDGothicNeo

@Composable
fun TransferDetailScreen(navController: NavController) {
    val amount = remember { mutableStateOf("") } // 입력된 금액을 저장하는 상태

    KakaobankandroidTheme {
        Column(modifier = Modifier.padding(16.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter= painterResource(id = R.drawable.back),
                    contentDescription = "back",
                    modifier = Modifier.size(10.dp),
                )
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "이황근",
                        style = TextStyle(
                            fontFamily = appleSDGothicNeo,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = KakaoBlack
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "우리 1002455041732",
                        style = TextStyle(
                            fontFamily = appleSDGothicNeo,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.LightGray
                        )
                    )
                }
                Text(
                    text = "취소",
                    style = TextStyle(
                        fontFamily = appleSDGothicNeo,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = KakaoBlack
                    )
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                Text(
                    text = amount.value.ifEmpty { "보낼금액" }, // amount 값이 없으면 "보낼금액" 표시
                    style = TextStyle(
                        fontFamily = appleSDGothicNeo,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFDDDDDD)
                    )
                )
            }
            Row(){

            }
            Keypad(amount = amount) // amount 값을 Keypad에 전달
            RoundedCornerButton(text = "다음", onClick = {})
                

        }
    }
}

@Composable
fun RoundedCornerButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),  // 둥근 모서리 설정
        modifier = Modifier
            .fillMaxWidth()  // 버튼의 넓이를 화면의 90%로 설정
            .height(64.dp),  // 버튼의 높이를 설정
        colors = ButtonDefaults.buttonColors(KakaoYellow)  // 버튼 색상 설정
    ) {
        Text(text = text, color = KakaoBlack, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Normal, fontFamily = appleSDGothicNeo)
        )
    }
}

@Composable
fun Keypad(amount: MutableState<String>) {
    val selectedKey = remember { mutableStateOf(-1) } // 선택된 키의 인덱스를 저장
    val keys = listOf(
        "1", "2", "3",
        "4", "5", "6",
        "7", "8", "9",
        "00", "0", "Back"
    )
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val buttonSize = maxWidth / 3 // 화면의 너비를 3등분한 크기

        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
        ) {
            repeat(4) { rowIndex ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    repeat(3) { columnIndex ->
                        val index = rowIndex * 3 + columnIndex
                        KeypadButton(
                            text = keys[index],
                            onClick = {
                                when (keys[index]) {
                                    "Back" -> {
                                        // 백스페이스: 마지막 문자 삭제
                                        if (amount.value.isNotEmpty()) {
                                            amount.value = amount.value.dropLast(1)
                                        }
                                    }
                                    else -> {
                                        // 숫자 추가
                                        amount.value += keys[index]
                                    }
                                }
                            },
                            size = buttonSize
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun KeypadButton(text: String, onClick: () -> Unit, size: Dp) {
    val contentColor = KakaoBlack

    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .width(size)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Normal)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TransferDetailScreenPreview(){
    TransferDetailScreen(navController = rememberNavController())
}