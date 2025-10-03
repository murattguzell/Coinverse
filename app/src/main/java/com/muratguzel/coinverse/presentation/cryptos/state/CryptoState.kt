package com.muratguzel.coinverse.presentation.cryptos.state

import com.muratguzel.coinverse.domain.model.Crypto

data class CryptoState(
    val isLoading: Boolean = false,
    val crypto: List<Crypto> = emptyList(),
    val error: String = ""
)