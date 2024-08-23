package com.kakaobank.tutorial.kakaobank_android.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.R
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.component.KakaoCard
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.component.KakaoWidthCard
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBackground
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBlack
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoYellow
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.appleSDGothicNeo
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.apple_bold
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.toss
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import com.kakaobank.tutorial.kakaobank_android.feature.transfer.TransferScreen
@Composable
fun HomeScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .background(KakaoBackground)
            .fillMaxHeight()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
        AccountCard(navController)
        AddCard()
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            ){
            FunctionCard("\uD83D\uDCB0", "매일\n용돈 받기")
            FunctionCard("\uD83D\uDCB2","신용대출\n비교하기")
            FunctionCard("\uD83D\uDDF3","통신비 아끼고\n5,000원 받기")
            FunctionCard("\uD83E\uDE77","신용점수\n알아보기")
        }
    }
}

@Composable
fun AccountCard(navController: NavController) {
    KakaoCard(modifier = Modifier.height(120.dp), color = KakaoYellow){
        Column(modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 16.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
                ){
                Icon(
                    painter = painterResource(id = R.drawable.ellipsis),
                    contentDescription = "Ellipsis Icon",
                    modifier = Modifier.size(10.dp),
                    tint = KakaoBlack
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Icon",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape),
                )
                Column(
                    modifier = Modifier.padding(start = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Text(
                            text = "이황근의 통장",
                            style = TextStyle(
                                fontFamily = appleSDGothicNeo,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = KakaoBlack
                            )
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star Icon",
                            modifier = Modifier.size(12.dp),
                            tint = KakaoBlack,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
//                            .background(Color.Red),
                    ) {
                        Text(
                            text = "9,999,9999,999원",
                            style = TextStyle(
                                fontFamily = appleSDGothicNeo,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = KakaoBlack,
                                textAlign = Center
                            )
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
                horizontalArrangement = Arrangement.End,
                ){
                Box(modifier = Modifier
                    .padding(end = 8.dp)
                    .background(Color(0x0A000000), RoundedCornerShape(16.dp))){
                    Text( modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) ,
                        text = "카드신청",
                        style = TextStyle(Color(0xFF333333), 10.sp, FontWeight.Bold, fontFamily = appleSDGothicNeo)

                    )
                }
                Box(modifier = Modifier
                    .background(Color(0x0A000000), RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate("transfer")
                    })
                {
                    Text( modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) ,
                        text = "이체",
                        style = TextStyle(Color(0xFF333333), 10.sp, FontWeight.Bold, fontFamily = appleSDGothicNeo)

                    )
                }
            }
        }
    }
}

@Composable
fun AddCard(){
    KakaoCard(modifier = Modifier.height(80.dp), color = Color.White) {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "Plus",
                modifier = Modifier.size(16.dp),
                tint = Color.LightGray,
            )
        }
    }
}

@Composable
fun FunctionCard(
    iconCode : String,
    title : String
){
    KakaoWidthCard(modifier = Modifier
        .padding(4.dp)
        .height(120.dp)
        .width(120.dp), color = Color.White) {
        Column(modifier = Modifier.padding(16.dp)){
            Box(modifier = Modifier.weight(0.5f)){
                Text(
                    text = iconCode,
                    style = TextStyle(
                        fontFamily = toss,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                    )
                )
            }
            Box(modifier = Modifier.weight(0.5f)){
                Text(
                    text = title,
                    style = TextStyle(
                        lineHeight = 24.sp,
                        fontFamily = apple_bold,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                    )
                )
            }

        }

    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
