package com.lifehealth.fitplanner.ui.recipe

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentRecipeBinding
import com.lifehealth.fitplanner.ui.recipe.detail.DetailFragment
import com.lifehealth.fitplanner.ui.recipe.rv.RecipesRVAdapter
import kotlinx.coroutines.launch

class RecipeFragment : Fragment() {

    private val binding by lazy { FragmentRecipeBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this).get(RecipesViewModel::class.java) }

    private val rvAdapter by lazy { RecipesRVAdapter() }

    private val queryLD = MutableLiveData<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setupRecyclerView()
        setupTextChangeListener()
        lifecycleScope.launch {
            observeTextChange()
        }
        setupRVAdapter()
    }

    private fun setupTextChangeListener() {
        binding.etQuery.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                queryLD.value = binding.etQuery.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    private fun setupRVAdapter() {
            rvAdapter.onItemClickListener = {
                SharedRecipe.recipe = it
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, DetailFragment())
                    addToBackStack(null)
                    commit()
                }
            }

    }

    private suspend fun observeTextChange() {
        queryLD.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                viewModel.getRecipeList(it)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.listRecipes.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.pbRecipes.visibility = View.GONE
                binding.rvRecipesList.visibility = View.VISIBLE
                binding.tvHitTV.visibility = View.GONE
            }
            rvAdapter.submitList(it)
        }
        viewModel.errorRequest.observe(viewLifecycleOwner) {
            if (it) {
                binding.tvHitTV.visibility = View.VISIBLE
            }
        }
    }


    private fun setupRecyclerView() {
        with(binding.rvRecipesList) {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
        }
    }


}