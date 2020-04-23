package com.hoon.dustsearch.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.charts.PieChart
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesure
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel

class FineDustFragment() : BaseFragment() {


    lateinit var viewDataBinding: FragmentFineDustBinding
    lateinit var viewModel: FineDustFragViewModel
    lateinit var pieChart: PieChart

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewDataBinding = FragmentFineDustBinding.inflate(inflater).apply {
            viewModel = FineDustFragViewModel()
            lifecycleOwner = this@FineDustFragment.viewLifecycleOwner
        }

        return viewDataBinding.root
    }
    private fun initPieChart(ctprvnMesure: List<CtprvnMesure>) {
        pieChart = viewDataBinding.fineDustPieChart
        pieChart.invalidate()
        pieChart.clear()



    }
}