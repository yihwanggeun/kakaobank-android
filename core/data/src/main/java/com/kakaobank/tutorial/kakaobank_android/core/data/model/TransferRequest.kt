package com.kakaobank.tutorial.kakaobank_android.core.data.model

// TransferRequest.kt
data class TransferRequest(
    val from: String,
    val to: String,
    val amount: Double
)