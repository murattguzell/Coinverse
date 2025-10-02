package com.muratguzel.coinverse.domain.repository

import com.muratguzel.coinverse.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCrypto(): CryptoDto
}