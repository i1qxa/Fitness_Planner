package com.lifehealth.fitplanner.ui.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentSleepBinding

class SleepFragment : Fragment() {

    private val binding by lazy { FragmentSleepBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtnClickListener()
    }

    private fun startAnim() {
        binding.tvBreathDirection.text = " Вдох"
        binding.ivProgress.animate().apply {
            duration = 3000
            scaleX(3F)
            scaleY(3F)
            withEndAction {
                launchBackAnim()
            }
        }
    }

    private fun launchBackAnim() {
        binding.tvBreathDirection.text = "Выдох"
        binding.ivProgress.animate().apply {
            duration = 1000
            scaleX(1F)
            scaleY(1F)
            withEndAction {
                startAnim()
            }
        }
    }

    private fun setupBtnClickListener() {
        binding.btnStartExercise.setOnClickListener {
            changeExerciseVisibility()
            changeBtnText()
            if (binding.btnStartExercise.text == requireContext().getString(R.string.stop)) startAnim()
        }
    }

    private fun changeBtnText() {
        binding.btnStartExercise.text =
            if (binding.btnStartExercise.text == requireContext().getString(
                    R.string.begin
                )
            ) requireContext().getString(R.string.stop) else requireContext().getString(R.string.begin)
    }

    private fun changeExerciseVisibility() {
        val visibility =
            if (binding.ivProgress.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        val descriptionVisibility = binding.ivProgress.visibility
        with(binding) {
            ivProgress.visibility = visibility
            tvBreathDirection.visibility = visibility
            tvInstruction.visibility = descriptionVisibility
        }
    }

}