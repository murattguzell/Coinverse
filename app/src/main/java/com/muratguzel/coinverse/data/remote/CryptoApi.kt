package com.muratguzel.coinverse.data.remote

import com.muratguzel.coinverse.data.remote.dto.CryptoDto
import com.muratguzel.coinverse.util.Constants.API_KEY
import com.muratguzel.coinverse.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoApi {
    @GET("economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ): CryptoDto
}