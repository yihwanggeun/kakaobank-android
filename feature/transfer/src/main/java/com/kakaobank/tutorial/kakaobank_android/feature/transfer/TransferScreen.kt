package com.kakaobank.tutorial.kakaobank_android.feature.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.R
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBlack
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaobankandroidTheme
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.appleSDGothicNeo

@Composable
fun TransferScreen(onNavigateToDetail: () -> Unit) {
    var inputText by remember { mutableStateOf("1002455041732") }
    KakaobankandroidTheme {

        Column(modifier = Modifier.padding(16.dp)) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = "닫기",
                    style = TextStyle(
                        KakaoBlack,
                        12.sp,
                        FontWeight.Normal,
                        fontFamily = appleSDGothicNeo
                    )
                )

            }

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "이체",
                style = TextStyle(
                    KakaoBlack,
                    16.sp,
                    FontWeight.Bold,
                    fontFamily = appleSDGothicNeo
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(12.dp)
                )
                BasicTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(start = 16.dp),
                    textStyle = TextStyle(
                        color = KakaoBlack,
                        fontSize = 14.sp,
                        fontFamily = appleSDGothicNeo
                    ),
                    decorationBox = { innerTextField ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box {
                                if (inputText.isEmpty()) {
                                    Text(
                                        "받는사람 이름 또는 계좌번호",
                                        color = Color(0xFF999999),
                                        fontSize = 14.sp,
                                        fontFamily = appleSDGothicNeo,
                                        modifier = Modifier.align(Alignment.CenterStart)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    }
                )

            }
            HorizontalDivider(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth(),
                color = Color(0xFF999999)
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.LightGray, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = "Plus Icon",
                        modifier = Modifier
                            .size(16.dp)  // 아이콘 크기를 더 작게 조정
                            .clip(CircleShape),
                        colorFilter = ColorFilter.tint(Color.White)  // 아이콘 색상을 흰색으로 변경 (선택사항)
                    )
                }
                Column(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = inputText,
                        style = TextStyle(
                            fontFamily = appleSDGothicNeo,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF23359C)
                        )
                    )
                    Box() {
                        Text(
                            text = "계좌로 이체",
                            style = TextStyle(
                                fontFamily = appleSDGothicNeo,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                                color = KakaoBlack,
                                textAlign = Center
                            )
                        )
                    }

                }
                Spacer(modifier = Modifier.weight(1f).background(Color.Blue))
                Text(
                    modifier = Modifier.clickable {
                        onNavigateToDetail()
                    },
                    text = ">",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )

            }

        }
    }
}

@Preview
@Composable
fun PreviewTransferScreen(){
    TransferScreen(onNavigateToDetail = {})

}