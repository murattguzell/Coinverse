package com.muratguzel.coinverse.domain.usecase.crypto

import com.muratguzel.coinverse.data.mapper.toCrypto
import com.muratguzel.coinverse.domain.model.Crypto
import com.muratguzel.coinverse.domain.repository.CryptoRepository
import com.muratguzel.coinverse.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class CryptoUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) {

    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) {
                emit(Resource.Success(crypto.toCrypto()))
            } else {
                emit(Resource.Error("No data!"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        }
    }
}