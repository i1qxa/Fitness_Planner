package com.lifehealth.fitplanner.ui.mude_note.rv

import androidx.recyclerview.widget.DiffUtil
import com.lifehealth.fitplanner.data.MoodDB

class MoodDiffCallback : DiffUtil.ItemCallback<MoodDB>() {

    override fun areItemsTheSame(oldItem: MoodDB, newItem: MoodDB): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MoodDB, newItem: MoodDB): Boolean {
        return oldItem == newItem
    }
}