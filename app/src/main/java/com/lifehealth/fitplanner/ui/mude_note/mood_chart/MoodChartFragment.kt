package com.lifehealth.fitplanner.ui.mude_note.mood_chart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.FragmentMoodChartBinding

class MoodChartFragment : Fragment() {

    private val binding by lazy { FragmentMoodChartBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MoodViewModel::class.java] }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel(){
        val chartModel = AAChartModel()
        viewModel.listOfMoodValue.observe(viewLifecycleOwner){
            chartModel.apply {
                chartType(AAChartType.Areaspline)
                title("Изменение настроения")
                backgroundColor("#FFFFFF")
                dataLabelsEnabled(true)
                series(arrayOf(
                    AASeriesElement()
                        .name("Время")
                        .data(it.toTypedArray())
                ))
            }
            binding.chartMood.aa_drawChartWithChartModel(chartModel)
        }

    }

}