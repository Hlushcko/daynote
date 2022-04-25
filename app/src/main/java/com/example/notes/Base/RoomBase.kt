package com.example.notes.Base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.Base.Dao.DaoCommand
import com.example.notes.Base.NotesRealization.Notes

@Database( entities = [Notes::class], version = 1)
abstract class RoomBase : RoomDatabase() {

    abstract fun getDaoBase(): DaoCommand

    companion object{
        private var database: RoomBase ?= null

        @Synchronized
        fun getInstance(context: Context): RoomBase {
            return if(database == null){
                database = Room.databaseBuilder(context, RoomBase::class.java, "database").build()
                database as RoomBase
            }else{
                database as RoomBase
            }
        }
    }

}