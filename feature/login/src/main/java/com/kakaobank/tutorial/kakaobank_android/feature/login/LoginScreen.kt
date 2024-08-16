package com.kakaobank.tutorial.kakaobank_android.feature.login


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoBlack
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.KakaoYellow
import com.kakaobank.tutorial.kakaobank_android.core.designsystem.theme.appleSDGothicNeo

/*  Arrangment / Alignment 차이
    Alignment - Column, Row, Box에서 자식 요소들을 수평 또는 수직방향으로 정렬
    Column - HorizontalAlignment
    Row - VerticalAlignment

    Arragement - 자식 요소들 간의 공간 분배 (Column이랑 Row에서만 사용)
    Column - VerticalArrangement
    Row - HorizontalArrangement
* */
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KakaoYellow),
        horizontalAlignment = Alignment.CenterHorizontally, // 수평 중앙 정렬
        verticalArrangement = Arrangement.SpaceBetween,

    ){
        Spacer(modifier = Modifier.height(50.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // 수평 중앙 정렬
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "AI Image",
                modifier = Modifier
                    .size(96.dp)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "본인 확인을 위해 로그인 패턴을 그리세요.",
                style = TextStyle(
                    fontFamily = appleSDGothicNeo, // 적용한 폰트 패밀리 사용
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                color = Color.Black,
                modifier = Modifier.padding(16.dp)
            )
        }

        // 하단 패턴 그리드
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(80.dp)
        ) {
            for (i in 0 until 3) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(80.dp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    for (j in 0 until 3) {
                        Dot(size = 8)
                    }
                }
            }
        }

        ImageButton(
            painter = painterResource(id = R.drawable.kakao_login_medium_wide),
            contentDescription = "Another Button",
            onClick = { // 카카오톡으로 로그인
                createKakaoToken(context, onLoginSuccess)
                      },
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun Dot(
    size: Int = 24, // 크기를 조정할 수 있도록 기본값을 설정합니다.
    color: Color = Color.Black // 색상도 조정 가능하도록 설정합니다.
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape) // 원형으로 클리핑합니다.
            .background(color) // 배경색을 설정합니다.
    )
}

fun createKakaoToken(context: android.content.Context, onLoginSuccess: () -> Unit) {

    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "카카오계정으로 로그인 실패", error)
        } else if (token != null) {
            Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
            onLoginSuccess()
        }
    }

    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                Log.e(TAG, "카카오톡으로 로그인 실패", error)

                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    return@loginWithKakaoTalk
                }

                // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
            } else if (token != null) {
                Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
            }
        }
    } else {
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}

@Composable
fun ImageButton(
    painter: Painter,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier.wrapContentSize().border(1.dp, KakaoBlack, shape = RoundedCornerShape(4.dp)) // 테두리 크기, 색상, 모양 설정
        ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // 버튼 배경색을 투명하게 설정
        ),
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageButtonPreview() {
    ImageButton(
        painter = painterResource(id = R.drawable.kakao_login_medium_wide), // 여기에 사용할 이미지 리소스를 설정합니다.
        contentDescription = "Sample Image Button",
        onClick = { /* 클릭 이벤트 처리 */ },
    )
}

@Preview(showBackground = true)
@Composable
fun DotPreview () {
    Dot()
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginSuccess = {})
}
