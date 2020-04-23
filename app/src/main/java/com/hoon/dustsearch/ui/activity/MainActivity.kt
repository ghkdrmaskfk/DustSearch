package com.hoon.dustsearch.ui.activity

import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationView
import com.hoon.dustsearch.R
import com.hoon.dustsearch.adapter.MainFragPagerAdapter

import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.databinding.ActivityMainBinding
import com.hoon.dustsearch.databinding.FragmentFineDustBinding
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesureResponse
import com.hoon.dustsearch.ui.fragment.FineDustFragment
import com.hoon.dustsearch.ui.fragment.WeatherFragment
import com.hoon.dustsearch.util.LocationUtils

import com.hoon.dustsearch.viewModel.activity.MainViewModel
import com.hoon.dustsearch.viewModel.fragment.FineDustFragViewModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_fine_dust.view.*
import kotlinx.android.synthetic.main.main_content_layout.view.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    NavigationView.OnNavigationItemSelectedListener {

    val TAG = "MainActivity"

    lateinit var adpater: MainFragPagerAdapter

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel =
        MainViewModel()

    override fun initStartView() {
        settingToolbar()
        dataBinding.navigationView.setNavigationItemSelectedListener(this)
    }

    override fun initDataBinding() {}

    override fun initAfterBinding() {

        val observer = Observer<CtprvnMesureResponse> { ctprvnMesureResponse ->
            Log.e(TAG, ctprvnMesureResponse.list.toString())
        }
        viewModel.apiCtprvnMesureLIst().observe(this, observer)

        adpater = MainFragPagerAdapter(supportFragmentManager)

        dataBinding.mainLayoutInclude.main_pager.adapter = adpater
        dataBinding.mainLayoutInclude.main_pager_indicator.setViewPager(dataBinding.mainLayoutInclude.main_pager)

        LocationUtils().getCurrentLocation(this)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> dataBinding.drawerLayout
                .openDrawer(GravityCompat.START, true) // 네비게이션 드로어 열기
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.fine_dust -> Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            R.id.weather -> Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
            R.id.theme_change -> Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
            R.id.search -> Toast.makeText(this, "4", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    override fun onBackPressed() {
        if (dataBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            dataBinding.drawerLayout.closeDrawers()
            Toast.makeText(this, getString(R.string.back_pressed_message), Toast.LENGTH_SHORT)
                .show()
        } else super.onBackPressed()
    }

    private fun settingToolbar() {
        setSupportActionBar(dataBinding.mainLayoutInclude.main_toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun getAdapter(): MainFragPagerAdapter {
        return adpater
    }
}
