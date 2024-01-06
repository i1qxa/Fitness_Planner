package com.lifehealth.fitplanner.ui.recipe.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.data.remote.RecipeItemShort

class RecipesRVAdapter:ListAdapter<RecipeItemShort, RecipesViewHolder>(RecipesDiffCallBack()) {

    var onItemClickListener : ((RecipeItemShort) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = R.layout.recipe_item_short
        return RecipesViewHolder(
            layoutInflater.inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            ivLogo.load(item.imgSmall){
                transformations(RoundedCornersTransformation(20.0f))
            }
            tvName.text = item.label
            tvKcal.text = item.calories.toString()
            itemView.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }
}