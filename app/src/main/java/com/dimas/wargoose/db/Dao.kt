package com.dimas.wargoose.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: Item)

    @Query("SELECT*FROM tables")
    fun getAllItems(): Flow<List<Item>>
}