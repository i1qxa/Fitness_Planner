package com.lifehealth.fitplanner.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(
    entities = [
        MoodDB::class
    ],
    exportSchema = false,
    version = 1
)
abstract class FPDataBase:RoomDatabase() {

    abstract fun moodDao():MoodDao

    companion object {
        private var INSTANCE: FPDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "fp_database_db"

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(application: Application): FPDataBase {
            INSTANCE?.let {
                return it
            }
            kotlinx.coroutines.internal.synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    FPDataBase::class.java,
                    DB_NAME)
//                ).createFromAsset("exercises.db")
                    .build()
                INSTANCE = db
                return db
            }
        }
    }

}