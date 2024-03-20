package com.dms.core_database.data

import androidx.room.Database
import com.dms.core_database.data.dao.WordInfoDao
import com.dms.core_database.data.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
abstract class WordInfoDatabase {

    abstract val dao: WordInfoDao
}