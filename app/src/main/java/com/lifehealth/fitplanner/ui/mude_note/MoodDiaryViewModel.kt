package com.lifehealth.fitplanner.ui.mude_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lifehealth.fitplanner.data.FPDataBase

class MoodDiaryViewModel(application: Application): AndroidViewModel(application) {

    private val dao = FPDataBase.getInstance(application).moodDao()

    val moodList = dao.getMoodListLD()

}