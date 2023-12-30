package com.lifehealth.fitplanner.data

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoodDB(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val date:Long,
    val note:String,
    val moodValue:Int,
){
    fun getFormattedDate():String{
        val time = Calendar.getInstance()
        time.timeInMillis = date
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return formatter.format(time)
    }
}
