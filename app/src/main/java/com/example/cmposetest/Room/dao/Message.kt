package com.example.cmposetest.Room.dao

import androidx.room.*
import com.example.cmposetest.Room.entitiy.Conversation


@Dao
interface Message {

    @Query("Select * From messageEntity")
    fun getMessage() : List<Conversation>

    @Query("DELETE From messageEntity")
    fun deleteLogin()

    @Insert
    fun insetMessage(insertEntity: Conversation)

    @Delete
    fun deleteMessage(deleteMessage: Conversation)

}