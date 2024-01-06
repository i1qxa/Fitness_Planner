package com.lifehealth.fitplanner.ui.recipe.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.data.remote.IngredientItem

class DetailRVAdapter: ListAdapter<IngredientItem, DetailViewHolder>(DetailDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = R.layout.ingredient_item
        return DetailViewHolder(
            layoutInflater.inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            logo.load(item.image){
                transformations(RoundedCornersTransformation(20.0f))
            }
            name.text = item.text
        }
    }
}