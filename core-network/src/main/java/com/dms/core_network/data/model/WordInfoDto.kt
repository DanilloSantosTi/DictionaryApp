package com.dms.core_network.data.model

import com.dms.core_network.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val word: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings.map { it.toMeaning() },
            word = word
        )
    }
}
