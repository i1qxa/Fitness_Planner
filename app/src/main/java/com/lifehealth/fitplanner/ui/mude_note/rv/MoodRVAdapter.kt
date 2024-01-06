package com.lifehealth.fitplanner.ui.mude_note.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.data.mood.MoodDB

class MoodRVAdapter : ListAdapter<MoodDB, MoodViewHolder>(MoodDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        return MoodViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.mood_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val item = getItem(position)
        val moodIcon = when(item.moodValue){
            1 -> R.drawable.mood_bad
            3 -> R.drawable.mood_good
            else -> R.drawable.mood_normal
        }
        with(holder){
            ivMoodIcon.setImageResource(moodIcon)
            tvDate.text = item.getFormattedDate()
            tvNote.text = item.note
        }
    }
}