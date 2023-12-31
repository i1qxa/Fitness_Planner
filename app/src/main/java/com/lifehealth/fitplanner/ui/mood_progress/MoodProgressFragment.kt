package com.lifehealth.fitplanner.ui.mood_progress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lifehealth.fitplanner.R

class MoodProgressFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                LineChartSample()
            }
        }
    }

    @Composable
    fun LineChartSample() {
        val testLineParameters: List<LineParameters> = listOf(
            LineParameters(
                label = "revenue",
                data = listOf(70.0, 00.0, 50.33, 40.0, 100.500, 50.0),
                lineColor = Color.Gray,
                lineType = LineType.CURVED_LINE,
                lineShadow = true,
            ),
            LineParameters(
                label = "Earnings",
                data = listOf(60.0, 80.6, 40.33, 86.232, 88.0, 90.0),
                lineColor = Color(0xFFFF7F50),
                lineType = LineType.DEFAULT_LINE,
                lineShadow = true
            ),
            LineParameters(
                label = "Earnings",
                data = listOf(1.0, 40.0, 11.33, 55.23, 1.0, 100.0),
                lineColor = Color(0xFF81BE88),
                lineType = LineType.CURVED_LINE,
                lineShadow = false,
            )
        )

        Box(Modifier) {
            LineChart(
                modifier = Modifier.fillMaxSize(),
                linesParameters = testLineParameters,
                isGrid = true,
                gridColor = Color.Blue,
                xAxisData = listOf("2015", "2016", "2017", "2018", "2019", "2020"),
                animateChart = true,
                showGridWithSpacer = true,
                yAxisStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                ),
                xAxisStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.W400
                ),
                yAxisRange = 14,
                oneLineChart = false,
                gridOrientation = GridOrientation.VERTICAL
            )
        }
    }
}