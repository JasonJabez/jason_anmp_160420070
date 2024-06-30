package com.example.jason_anmp_160420070.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jason_anmp_160420070.model.ModelDatabase

val DB_NAME = "newbie_anmp_uas"

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE news ADD COLUMN summary VARCHAR")
    }
}

fun buildDb(context: Context): ModelDatabase{
    val db = Room.databaseBuilder(
        context.applicationContext,
        ModelDatabase::class.java,
        DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()

    return db
}