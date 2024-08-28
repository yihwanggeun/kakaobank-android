package com.kakaobank.tutorial.kakaobank_android.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kakaobank.tutorial.kakaobank_android.R
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBackground
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBlack
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.appleSDGothicNeo
import com.kakaobank.tutorial.kakaobank_android.feature.home.HomeRoute
import com.kakaobank.tutorial.kakaobank_android.feature.main.ui.theme.KakaobankandroidTheme
import com.kakaobank.tutorial.kakaobank_android.feature.home.HomeScreen

@Composable
fun MainScreen(navController: NavController) {
    val bottomNavController = rememberNavController()

    /*
        Scaffold - Material Design의 기본 레이아웃을 제공하는 컴포저블
        Column - 수직 방향으로 배치하는 컨테이너
        Scaffold랑 Column의 차이 - Scaffold는 기본적인 구성을 해주는 컴포저블
        Scaffold 안에 TopBar - Content - Bottom Bar
        modifier - 컴포저블의 레이아웃을 조정하는 데 사용되는 속성
     */
    val selectedTab = remember { mutableStateOf(0) } // 기본적으로 첫 번째 탭이 선택됨

    KakaobankandroidTheme {
        Scaffold(
            topBar = {
                MainTopBar()
            },
            content = { paddingValues ->
                NavHost(
                    navController = bottomNavController,
                    startDestination = HomeRoute.route,
                    Modifier.padding(paddingValues)
                ) {
                    composable(HomeRoute.route) {
                        HomeScreen(
                            onTransferClick = { navController.navigate("transfer_flow") }
                        )
                    }
                }
            },
            bottomBar = {
                MainBottomBar(
                    selectedIndex = selectedTab.value,
                    onTabSelected = { index ->
                        selectedTab.value = index
                        val route = when (index) {
                            0 -> "home"
                            1 -> "benefits"
                            2 -> "products"
                            3 -> "more"
                            else -> "home"
                        }
                        bottomNavController.navigate(route)
                    }
                )
            }
        )


    }


}


@Composable
fun MainBottomBar(selectedIndex: Int, onTabSelected: (Int) -> Unit) {

    Column() {
        HorizontalDivider(
            modifier = Modifier
                .height(0.1.dp)
                .fillMaxWidth(),
            color = KakaoBlack
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .navigationBarsPadding()
            .height(56.dp)
            .background(Color.White),

            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

        ) {
            BottomBarItem(
                iconId = R.drawable.home,
                label = "홈",
                isSelected = selectedIndex == 0,
                onClick = { onTabSelected(0) }
            )
            BottomBarItem(
                iconId = R.drawable.gift,
                label = "혜택",
                isSelected = selectedIndex == 1,
                onClick = { onTabSelected(1) }
            )
            BottomBarItem(
                iconId = R.drawable.list,
                label = "상품",
                isSelected = selectedIndex == 2,
                onClick = { onTabSelected(2) }
            )
            BottomBarItem(
                iconId = R.drawable.ellipsis,
                label = "전체",
                isSelected = selectedIndex == 3,
                onClick = { onTabSelected(3) }
            )

        }
    }

}
@Composable
fun BottomBarItem(iconId: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .clickable { onClick() }, // 클릭 시 호출
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(20.dp),
            tint = if (isSelected) Color.Black else Color(0xFFBBBBBB) // 아이콘 색상 설정
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            style = TextStyle(
                fontFamily = appleSDGothicNeo,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = if (isSelected) Color.Black else Color(0xFFBBBBBB) // 텍스트 색상 설정
            )
        )
    }
}

@Composable
fun MainTopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .background(KakaoBackground)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = "이황근",
            style = TextStyle(KakaoBlack, 24.sp, FontWeight.Bold, fontFamily = appleSDGothicNeo)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.background(Color(0xFFF1F1F1), RoundedCornerShape(16.dp))){
            Text( modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp) ,
                text = "내 계좌",
                style = TextStyle(KakaoBlack, 12.sp, FontWeight.Bold, fontFamily = appleSDGothicNeo)

            )
        }
        Spacer(modifier = Modifier
            .size(20.dp)
            .weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.alarm),
            contentDescription = "alarm",
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Composable
fun BenefitsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text("Benefits Screen")
    }
}

@Composable
fun ProductsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text("Products Screen")
    }
}

@Composable
fun MoreScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text("More Screen")
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KakaobankandroidTheme {
        MainScreen(navController = rememberNavController())
    }
}