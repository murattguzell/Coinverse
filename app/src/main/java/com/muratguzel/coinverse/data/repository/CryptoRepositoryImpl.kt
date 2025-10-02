package com.muratguzel.coinverse.data.repository

import com.muratguzel.coinverse.data.remote.CryptoApi
import com.muratguzel.coinverse.data.remote.dto.CryptoDto
import com.muratguzel.coinverse.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoApi
) : CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}