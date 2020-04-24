package com.hoon.dustsearch.ui.fragment

import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesureResponse
import com.hoon.dustsearch.model.MsrstnAcctoRltmMesureDnsty.MsrstnAcctoRltmMesureDnstyResponse
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel

class FineDustFragment() : BaseFragment() {

    lateinit var dataBinding: FragmentFineDustBinding
    lateinit var viewModel: FineDustFragViewModel
    /*lateinit var pieChart: PieChart*/

    var fineDustInt: Int = 74
    var fineDustChoInt: Int = 31

    override fun initStartView() {}

    override fun initDataBinding() {}

    override fun initAfterBinding() {}

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        dataBinding = FragmentFineDustBinding.inflate(inflater).apply {
            viewModel = FineDustFragViewModel()
            lifecycleOwner = this@FineDustFragment.viewLifecycleOwner
        }

        val observer = Observer<MsrstnAcctoRltmMesureDnstyResponse> { msrstnAcctoRltmMesureDnstyResponse ->
            Log.e(TAG, msrstnAcctoRltmMesureDnstyResponse.list.toString())
        }
        viewModel.apiMsrstnAcctoRltmMesureDnstyList().observe(viewLifecycleOwner, observer)

        return dataBinding.root
    }

    fun setFineDuseGauge(value: Int) {
        if (value <= 50) {
            dataBinding.fineDustGauge.value = value
            dataBinding.fineDustGauge.pointEndColor = Color.BLUE
        } else if (value <= 100) {
            dataBinding.fineDustGauge.value = value
            dataBinding.fineDustGauge.pointEndColor = Color.GREEN
        } else if (value <= 250) {
            dataBinding.fineDustGauge.value = value
            dataBinding.fineDustGauge.pointEndColor = Color.MAGENTA
        } else {
            dataBinding.fineDustGauge.value = value
            dataBinding.fineDustGauge.pointEndColor = Color.RED
        }
    }

    /*fun setPieChart() {
        pieChart = viewDataBinding.fineDustPieChart

        val NoOfEmp = ArrayList<PieEntry>()

        NoOfEmp.add(PieEntry(25f, getString(R.string.graph_level_good)))
        NoOfEmp.add(PieEntry(25f, getString(R.string.graph_level_usually)))
        NoOfEmp.add(PieEntry(25f, getString(R.string.graph_level_bad)))
        NoOfEmp.add(PieEntry(25f, getString(R.string.graph_level_very_bad)))
        val dataSet = PieDataSet(NoOfEmp, "")

        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 1f
        dataSet.iconsOffset = MPPointF(0F, 20f)
        dataSet.selectionShift = 1f
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

        val data = PieData(dataSet)
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.WHITE)
        pieChart.data = data
        pieChart.highlightValues(null)
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.invalidate()
        pieChart.animateXY(1000, 1000)
    }*/
}