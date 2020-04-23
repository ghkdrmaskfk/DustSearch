package com.hoon.dustsearch.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.databinding.FragmentWeatherBinding
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel
import com.hoon.dustsearch.viewModel.fragment.WeatherFragViewModel

class WeatherFragment : BaseFragment() {

    private lateinit var viewDataBinding: FragmentWeatherBinding
    lateinit var viewModel: WeatherFragViewModel

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewDataBinding = FragmentWeatherBinding.inflate(inflater).apply {

            viewModel = WeatherFragViewModel()
            lifecycleOwner = this@WeatherFragment.viewLifecycleOwner
        }
        return viewDataBinding.root
    }
}