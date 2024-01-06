package com.lifehealth.fitplanner.data.mood

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoodDao {
    @Query("SELECT * FROM mooddb ORDER BY date DESC")
    fun getMoodListLD():LiveData<List<MoodDB>>

    @Query("SELECT moodValue FROM MoodDB")
    fun getListOfMoodValue():LiveData<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMoodNote(note: MoodDB)

    @Delete
    suspend fun removeMoodNote(note: MoodDB)

}