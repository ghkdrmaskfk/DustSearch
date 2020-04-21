package com.hoon.dustsearch.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.hoon.dustsearch.Application
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseFragment
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel
import kotlinx.android.synthetic.main.activity_main.*

class FineDustFragment : BaseFragment(){

    private lateinit var viewDataBinding: FragmentFineDustBinding
    lateinit var viewModel: ViewModel
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




}