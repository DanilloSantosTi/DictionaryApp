package com.dms.core_network.data.repository

import com.dms.core_network.data.model.WordInfoDto
import com.dms.core_network.data.service.DictionaryApi
import com.dms.core_network.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfoDto>>> = flow {
        emit(Resource.Loading())

        try {
            val remoteWordInfos = api.getWordInfo(word)
            emit(
                Resource.Success(
                    data = remoteWordInfos
                )
            )
        } catch (httpException: HttpException) {
            emit(
                Resource.Error(
                    message = "Internet error!"
                )
            )
        }
    }
}