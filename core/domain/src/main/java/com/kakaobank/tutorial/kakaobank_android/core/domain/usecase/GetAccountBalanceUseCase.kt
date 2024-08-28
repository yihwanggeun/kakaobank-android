package com.kakaobank.tutorial.kakaobank_android.core.domain.usecase

import com.kakaobank.tutorial.kakaobank_android.core.data.UserRepository
import com.kakaobank.tutorial.kakaobank_android.core.data.model.Account
import javax.inject.Inject

class GetAccountBalanceUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(userId: String): Result<Account> {
        return repository.getAccountBalance(userId)
    }
}