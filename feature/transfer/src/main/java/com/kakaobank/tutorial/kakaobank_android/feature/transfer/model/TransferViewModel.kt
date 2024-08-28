package com.kakaobank.tutorial.kakaobank_android.feature.transfer.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakaobank.tutorial.kakaobank_android.core.data.model.TransferResponse
import com.kakaobank.tutorial.kakaobank_android.core.domain.usecase.TransferMoneyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransferViewModel @Inject constructor(
    private val transferMoneyUseCase: TransferMoneyUseCase
) : ViewModel() {

    private val _transferResult = MutableLiveData<TransferResponse>()
    val transferResult: LiveData<TransferResponse> = _transferResult

    fun transferMoney(from: String, to: String, amount: Double) {
        viewModelScope.launch {
            Log.d("TransferViewModel", "transferMoney called with from: $from, to: $to, amount: $amount")
            val result = transferMoneyUseCase(from, to, amount)
            Log.d("TransferViewModel", "Transfer result: $result")
            result.onSuccess { _transferResult.value = it }
        }
    }
}
