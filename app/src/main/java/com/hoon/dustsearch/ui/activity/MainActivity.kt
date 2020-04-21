package com.hoon.dustsearch.ui.activity

import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.databinding.ActivityMainBinding
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesureResponse
import com.hoon.dustsearch.ui.fragment.FineDustFragment
import com.hoon.dustsearch.ui.fragment.WeatherFragment
import com.hoon.dustsearch.viewModel.activity.MainViewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    val TAG = "MainActivity"

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel =
        MainViewModel()

    override fun initStartView() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
        viewDataBinding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
        viewDataBinding.bottomNavigationView.selectedItemId = R.id.fine_dust

        val observer = Observer<CtprvnMesureResponse> { ctprvnMesureResponse->
            Log.e(TAG, ctprvnMesureResponse.list.toString())
        }
        viewModel.apiCtprvnMesureLIst().observe(this, observer)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.fine_dust -> { supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FineDustFragment()).commit() }

            R.id.weather -> { supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WeatherFragment()).commit() }
        }
        return true
    }
}
