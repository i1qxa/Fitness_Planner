package com.lifehealth.fitplanner.ui.mude_note.mood_chart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.lifehealth.fitplanner.data.FPDataBase

class MoodViewModel(application: Application) : AndroidViewModel(application) {

    val dao = FPDataBase.getInstance(application).moodDao()

    val chartModel = AAChartModel()

    val listOfMoodValue = dao.getListOfMoodValue()

}