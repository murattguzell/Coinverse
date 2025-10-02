package com.muratguzel.coinverse.data.remote.dto

import com.muratguzel.coinverse.domain.model.Crypto

data class CryptoDto(
    val result: List<Result>,
    val success: Boolean
)

