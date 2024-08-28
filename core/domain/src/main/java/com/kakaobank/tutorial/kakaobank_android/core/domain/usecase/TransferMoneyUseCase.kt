package com.kakaobank.tutorial.kakaobank_android.core.domain.usecase

import com.kakaobank.tutorial.kakaobank_android.core.data.UserRepository
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferResponse
import javax.inject.Inject

class TransferMoneyUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(from: String, to: String, amount: Double): Result<TransferResponse> {
        return repository.transferMoney(from, to, amount)
    }
}