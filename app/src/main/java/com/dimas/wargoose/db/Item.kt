package com.dimas.wargoose.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,    //в эту переменную записываем уникальное ИД, которое автогенериться, в аннотации
    @ColumnInfo(name = "mos")
    var mos: String,
    @ColumnInfo(name = "bun")
    var bun: String,
    @ColumnInfo(name = "rubchic")
    var rubchic: String,
    @ColumnInfo(name = "lukashenko")
    var lukashenko: String
)
