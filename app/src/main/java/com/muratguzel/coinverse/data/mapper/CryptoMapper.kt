package com.muratguzel.coinverse.data.mapper

import com.muratguzel.coinverse.data.remote.dto.CryptoDto
import com.muratguzel.coinverse.domain.model.Crypto

fun CryptoDto.toCrypto(): List<Crypto> {
    return result.map {result ->
        Crypto(
            code = result.code,
            currency = result.currency,
            pricestr = result.pricestr
        )
    }
}