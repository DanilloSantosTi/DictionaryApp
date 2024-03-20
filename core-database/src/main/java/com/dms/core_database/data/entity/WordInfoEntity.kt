package com.dms.core_database.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dms.core_network.domain.model.Meaning
import com.dms.core_network.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            meanings = meanings
        )
    }
}
