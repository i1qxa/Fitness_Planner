package com.lifehealth.fitplanner.ui.recipe

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lifehealth.fitplanner.data.remote.RecipeItemShort
import com.lifehealth.fitplanner.data.remote.RetrofitService
import kotlinx.coroutines.launch

class RecipesViewModel(application: Application) : AndroidViewModel(application) {

    private val retrofit = RetrofitService.getInstance()


    val listRecipes = MutableLiveData<List<RecipeItemShort?>>()

    val errorRequest = MutableLiveData<Boolean>()

    suspend fun getRecipeList(query:String) {
        viewModelScope.launch {
            val recipes = mutableListOf<RecipeItemShort?>()
            val response = retrofit.getRecipeResponse(
                "public",
                query,
                RetrofitService.appId,
                RetrofitService.appKey
            )
            if (response.isSuccessful) {
                if (response.body()?.count == 0){
                    errorRequest.value = true
                    errorRequest.value = false
                }
                response.body()?.hits?.map {
                    recipes.add(it.recipe?.getRecipeShort())
                }
                listRecipes.postValue(recipes)
            }
        }
    }



}