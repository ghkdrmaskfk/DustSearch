package com.hoon.dustsearch.ui.fragment

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.model.MsrstnAcctoRltmMesureDnsty.MsrstnAcctoRltmMesureDnstyResponse
import com.hoon.dustsearch.util.ColorChangeObj
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FineDustFragment : BaseFragment() {

    val TAG = "FineDustFragment"
    lateinit var ctx: Context

    companion object {
        private const val FINE_DUST_GOOD = 30
        private const val FINE_DUST_USUALLY = 80
        private const val FINE_DUST_BAD = 150

        private const val ULTRA_FINE_DUST_GOOD = 15
        private const val ULTRA_FINE_DUST_USUALLY = 50
        private const val ULTRA_FINE_DUST_BAD = 100

        private const val GUAGE_MAX_SIZE = 300
    }

    lateinit var dataBinding: FragmentFineDustBinding
    lateinit var viewModel: FineDustFragViewModel

    /*lateinit var pieChart: PieChart*/

    var fineDustInt: Int = 174
    var ultrafineDustInt: Int = 76

    override fun initStartView() {
        ctx = this.context!!
    }

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
            Log.e(TAG, msrstnAcctoRltmMesureDnstyResponse.toString())
        }
        viewModel.apiMsrstnAcctoRltmMesureDnstyList().observe(viewLifecycleOwner, observer)

        setFineDuseGauge(fineDustInt, ultrafineDustInt)
        startAnimation()

        return dataBinding.root
    }

    fun setFineDuseGauge(fineDust: Int, ultraFineDust: Int) {

        if (fineDust <= FINE_DUST_GOOD) {
            dataBinding.fineDustGauge.value = fineDust
            dataBinding.fineDustGauge.pointStartColor = Color.BLUE
            dataBinding.fineDustGaugeTv.text = getString(R.string.graph_level_good)
        } else if (fineDust <= FINE_DUST_USUALLY) {
            dataBinding.fineDustGauge.value = fineDust
            dataBinding.fineDustGauge.pointStartColor = Color.GREEN
            dataBinding.fineDustGaugeTv.text = getString(R.string.graph_level_usually)
        } else if (fineDust <= FINE_DUST_BAD) {
            dataBinding.fineDustGauge.value = fineDust
            dataBinding.fineDustGauge.pointStartColor = Color.MAGENTA
            dataBinding.fineDustGaugeTv.text = getString(R.string.graph_level_bad)
        } else {
            dataBinding.fineDustGauge.value = fineDust
            dataBinding.fineDustGauge.pointStartColor = Color.RED
            dataBinding.fineDustGaugeTv.text = getString(R.string.graph_level_very_bad)
        }

        if (ultraFineDust <= ULTRA_FINE_DUST_GOOD) {
            dataBinding.ultraFineDustGauge.value = ultraFineDust
            dataBinding.ultraFineDustGauge.pointStartColor = Color.BLUE
            dataBinding.ultraFineDustGaugeTv.text = getString(R.string.graph_level_good)
        } else if (ultraFineDust <= ULTRA_FINE_DUST_USUALLY) {
            dataBinding.ultraFineDustGauge.value = ultraFineDust
            dataBinding.ultraFineDustGauge.pointStartColor = Color.GREEN
            dataBinding.ultraFineDustGaugeTv.text = getString(R.string.graph_level_usually)
        } else if (ultraFineDust <= ULTRA_FINE_DUST_BAD) {
            dataBinding.ultraFineDustGauge.value = ultraFineDust
            dataBinding.ultraFineDustGauge.pointStartColor = Color.MAGENTA
            dataBinding.ultraFineDustGaugeTv.text = getString(R.string.graph_level_bad)
        } else {
            dataBinding.ultraFineDustGauge.value = ultraFineDust
            dataBinding.ultraFineDustGauge.pointStartColor = Color.RED
            dataBinding.ultraFineDustGaugeTv.text = getString(R.string.graph_level_very_bad)
        }

        GlobalScope.launch {
            for (i in 1..fineDustInt) {
                dataBinding.fineDustGauge.value = i
                /*activity?.runOnUiThread {
                    dataBinding.fineDustGaugeTv.text =
                        String.format(getString(R.string.gauge_format_text),
                            i.toString(), GUAGE_MAX_SIZE)
                }*/
                delay(10)
            }
        }

        GlobalScope.launch {
            for (i in 1..ultrafineDustInt) {
                dataBinding.fineDustGauge.value = i
                /*activity?.runOnUiThread {
                    dataBinding.ultraFineDustGaugeTv.text =
                        String.format(getString(R.string.gauge_format_text),
                            i.toString(), GUAGE_MAX_SIZE)
                }*/
                delay(10)
            }
        }
    }

    fun startAnimation() {
        val aniFade: Animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_in)
        dataBinding.gpsIcon.startAnimation(aniFade)
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