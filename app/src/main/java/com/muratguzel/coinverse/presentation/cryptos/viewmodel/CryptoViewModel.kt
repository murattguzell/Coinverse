package com.muratguzel.coinverse.presentation.cryptos.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratguzel.coinverse.domain.usecase.crypto.CryptoUseCase
import com.muratguzel.coinverse.presentation.cryptos.state.CryptoState
import com.muratguzel.coinverse.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
) : ViewModel() {


    private val _cryptoState = mutableStateOf(CryptoState())
    val cryptoState: State<CryptoState> = _cryptoState

    init {
        getCrypto()
    }

    private var job: Job? = null

    private fun getCrypto() {
        job?.cancel()
        job = cryptoUseCase.getCrypto().onEach {
            when (it) {
                is Resource.Error<*> -> {
                    _cryptoState.value = cryptoState.value.copy(
                        error = it.message ?: "error",
                        isLoading = false
                    )
                }

                is Resource.Success -> {
                    _cryptoState.value = cryptoState.value.copy(
                        crypto = it.data ?: emptyList(),
                        isLoading = false
                    )

                }

                is Resource.Loading -> {
                    _cryptoState.value = cryptoState.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}