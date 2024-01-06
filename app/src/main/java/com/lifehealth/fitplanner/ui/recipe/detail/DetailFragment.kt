package com.lifehealth.fitplanner.ui.recipe.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.data.remote.RecipeItemShort
import com.lifehealth.fitplanner.databinding.FragmentDetailBinding
import com.lifehealth.fitplanner.ui.recipe.SharedRecipe


class DetailFragment : Fragment() {

    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }
    private val recipeItem by lazy { SharedRecipe.recipe }
    private val rvAdapter by lazy { DetailRVAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.ivLogo.load(recipeItem?.imgRegular){
            transformations(RoundedCornersTransformation(20.0f))
        }
        binding.tvRecipeName.text = recipeItem?.label
        binding.tvKcalValue.text = (recipeItem?.calories?:1).toString()
        binding.tvTotalTimeValue.text = (recipeItem?.totalTime?:10).toString()
        rvAdapter.submitList(recipeItem?.ingredientsList)
    }

    private fun setupRecyclerView() {
        with(binding.rvIngredientsList) {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
        }
    }

}