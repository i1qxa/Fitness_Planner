package com.lifehealth.fitplanner.ui.mude_note.mood_item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentMoodItemBinding

class MoodItemFragment : DialogFragment() {

    private val binding by lazy { FragmentMoodItemBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MoodItemViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnClickListeners()
        observeFinish()
    }

    private fun setupBtnClickListeners(){

        binding.btnDismissNote.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnAddNote.setOnClickListener {
            val moodValue = when(binding.rgMoodValue.checkedRadioButtonId){
                R.id.rbMoodBad -> 1
                R.id.rbMoodGood ->3
                else -> 2
            }
            viewModel.addNewMoodNote(binding.etMoodNote.text.toString(), moodValue)
            viewModel.refreshShouldFinish()
        }

    }

    private fun observeFinish(){
        viewModel.shouldFinish.observe(viewLifecycleOwner){
            if (it){
                parentFragmentManager.popBackStack()
            }
        }
    }

}