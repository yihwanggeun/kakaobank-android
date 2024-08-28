package com.kakaobank.tutorial.kakaobank_android.core.data

import com.kakaobank.tutorial.kakaobank_android.core.data.api.UserApiService
import com.kakaobank.tutorial.kakaobank_android.core.data.model.Account
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferRequest
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferResponse
import javax.inject.Inject

class UserRepository @Inject constructor (private val apiService: UserApiService) {
    suspend fun getAccountBalance(userId: String): Result<Account> {
        return try {
            val response = apiService.getAccountBalance(userId)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to get account balance"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun transferMoney(from: String, to: String, amount: Double): Result<TransferResponse> {
        return try {
            val response = apiService.transferMoney(TransferRequest(from, to, amount))
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to transfer money"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}