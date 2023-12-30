package com.lifehealth.fitplanner.ui.mude_note.rv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lifehealth.fitplanner.R

class MoodViewHolder(itemView:View):ViewHolder(itemView) {
    val ivMoodIcon = itemView.findViewById<ImageView>(R.id.ivMoodIcon)
    val tvDate = itemView.findViewById<TextView>(R.id.tvMoodNoteDate)
    val tvNote = itemView.findViewById<TextView>(R.id.tvMoodNote)
}