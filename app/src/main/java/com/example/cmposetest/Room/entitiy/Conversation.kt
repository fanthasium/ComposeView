package com.example.cmposetest.Room.entitiy


import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity



//get , set
@Entity(tableName = "message")
data class Conversation (

    @PrimaryKey(autoGenerate = true) val message : Int,

    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "timer") val timer: String?,
    @ColumnInfo(name = "subTittle") val subTittle: String?,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "caller") val caller: String?,
)
