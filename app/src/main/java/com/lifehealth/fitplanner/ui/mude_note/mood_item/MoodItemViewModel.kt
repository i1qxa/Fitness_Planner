package com.lifehealth.fitplanner.ui.mude_note.mood_item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lifehealth.fitplanner.data.FPDataBase
import com.lifehealth.fitplanner.data.mood.MoodDB
import kotlinx.coroutines.launch
import java.util.Calendar

class MoodItemViewModel(application: Application):AndroidViewModel(application) {

    private val dao = FPDataBase.getInstance(application).moodDao()

    val shouldFinish = MutableLiveData<Boolean>()

    fun addNewMoodNote(note:String, value:Int){
        viewModelScope.launch {
            dao.addMoodNote(
                MoodDB(
                    0,
                    Calendar.getInstance().timeInMillis,
                    note,
                    value
                )
            )
            shouldFinish.postValue(true)
        }
    }

    fun refreshShouldFinish(){
        shouldFinish.value = false
    }

}