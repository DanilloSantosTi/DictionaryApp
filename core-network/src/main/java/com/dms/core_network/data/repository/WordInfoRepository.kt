package com.dms.core_network.data.repository

import com.dms.core_network.data.model.WordInfoDto
import com.dms.core_network.util.Resource
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfoDto>>>
}