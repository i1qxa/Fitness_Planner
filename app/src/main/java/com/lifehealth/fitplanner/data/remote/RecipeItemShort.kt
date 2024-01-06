package com.lifehealth.fitplanner.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeItemShort(
    val uri:String,
    val label:String?,
    val imgRegular:String?,
    val imgSmall:String?,
    val calories:Int?,
    val totalTime:Double?,
    val ingredientsList:List<IngredientItem>
):Parcelable{

}
