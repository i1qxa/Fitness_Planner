package com.lifehealth.fitplanner.ui.recipe.rv

import androidx.recyclerview.widget.DiffUtil
import com.lifehealth.fitplanner.data.remote.RecipeItemShort

class RecipesDiffCallBack:DiffUtil.ItemCallback<RecipeItemShort>() {

    override fun areItemsTheSame(oldItem: RecipeItemShort, newItem: RecipeItemShort): Boolean {
        return oldItem.label == newItem.label
    }

    override fun areContentsTheSame(oldItem: RecipeItemShort, newItem: RecipeItemShort): Boolean {
        return oldItem.label == newItem.label
    }
}