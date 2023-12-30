package com.lifehealth.fitplanner.ui.encouragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lifehealth.fitplanner.databinding.FragmentEncouragementBinding

class EncouragementFragment : Fragment() {

    private val binding by lazy { FragmentEncouragementBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}