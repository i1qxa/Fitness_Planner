package com.lifehealth.fitplanner.ui.recipe.detail

import androidx.recyclerview.widget.DiffUtil
import com.lifehealth.fitplanner.data.remote.IngredientItem

class DetailDiffCallBack():DiffUtil.ItemCallback<IngredientItem>(){
    override fun areItemsTheSame(oldItem: IngredientItem, newItem: IngredientItem): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: IngredientItem, newItem: IngredientItem): Boolean {
        return oldItem == newItem
    }
}
