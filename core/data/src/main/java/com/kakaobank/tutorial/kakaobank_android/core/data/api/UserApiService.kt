package com.kakaobank.tutorial.kakaobank_android.core.data.api

import com.kakaobank.tutorial.kakaobank_android.core.data.model.Account
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferRequest
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApiService {
    @GET("account/{userId}")
    suspend fun getAccountBalance(@Path("userId") userId: String): Response<Account>

    @POST("transfer")
    suspend fun transferMoney(@Body transferRequest: TransferRequest): Response<TransferResponse>
}