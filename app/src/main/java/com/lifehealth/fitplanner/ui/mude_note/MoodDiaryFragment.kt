package com.lifehealth.fitplanner.ui.mude_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentMudeNoteBinding
import com.lifehealth.fitplanner.ui.mude_note.mood_chart.MoodChartFragment
import com.lifehealth.fitplanner.ui.mude_note.mood_item.MoodItemFragment
import com.lifehealth.fitplanner.ui.mude_note.mood_item.MoodItemViewModel
import com.lifehealth.fitplanner.ui.mude_note.rv.MoodRVAdapter

class MoodDiaryFragment : Fragment() {

    private val binding by lazy { FragmentMudeNoteBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MoodDiaryViewModel::class.java] }
    private val rv by lazy { binding.rvMoodNotes }
    private val rvAdapter by lazy { MoodRVAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnAddNoteClickListener()
        setupRV()
        observeNotes()
    }

    private fun observeNotes(){
        viewModel.moodList.observe(viewLifecycleOwner){
            rvAdapter.submitList(it)
        }
    }

    private fun setupRV(){
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
    }

    private fun setupBtnAddNoteClickListener(){
        binding.fabAddMoodNote.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, MoodItemFragment())
                addToBackStack(null)
                commit()
            }
        }
        binding.fabChart.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, MoodChartFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

}