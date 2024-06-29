package com.example.jason_anmp_160420070.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class, News::class), version = 1)

abstract class ModelDatabase: RoomDatabase() {
    abstract fun modelDao(): ModelDAO

    companion object{
        @Volatile private var instance: ModelDatabase ?= null
        private var LOCK = Any()

        fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ModelDatabase::class.java,
                "newbie_anmp_uas")
            .build()

        operator fun invoke(context:Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance ?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}