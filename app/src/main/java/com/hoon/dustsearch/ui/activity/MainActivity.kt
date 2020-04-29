package com.hoon.dustsearch.ui.activity

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationView
import com.hoon.dustsearch.R
import com.hoon.dustsearch.adapter.MainFragPagerAdapter

import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.databinding.ActivityMainBinding
import com.hoon.dustsearch.dialog.ThemeSelectDialog
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesureResponse
import com.hoon.dustsearch.util.ColorChangeObj
import com.hoon.dustsearch.util.LocationUtils

import com.hoon.dustsearch.viewModel.activity.MainViewModel
import kotlinx.android.synthetic.main.main_content_layout.view.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    NavigationView.OnNavigationItemSelectedListener {

    val TAG = "MainActivity"
    lateinit var dialog: ThemeSelectDialog

    lateinit var adpater: MainFragPagerAdapter

    override val layoutResourceId: Int
        get() = com.hoon.dustsearch.R.layout.activity_main

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.hoon.dustsearch.R.menu.menu_toolbar_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> dataBinding.drawerLayout
                .openDrawer(GravityCompat.START, true) // 네비게이션 드로어 열기
            com.hoon.dustsearch.R.id.theme_change -> showThemeSelectDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.hoon.dustsearch.R.id.fine_dust -> Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            com.hoon.dustsearch.R.id.weather -> Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
            com.hoon.dustsearch.R.id.theme_change -> Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
            com.hoon.dustsearch.R.id.search -> Toast.makeText(this, "4", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    override fun onBackPressed() {
        if (dataBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            dataBinding.drawerLayout.closeDrawers()
            Toast.makeText(this, getString(com.hoon.dustsearch.R.string.back_pressed_message), Toast.LENGTH_SHORT)
                .show()
        } else super.onBackPressed()
    }

    private fun settingToolbar() {
        setSupportActionBar(dataBinding.mainLayoutInclude.main_toolbar)
        supportActionBar?.setHomeAsUpIndicator(com.hoon.dustsearch.R.drawable.ic_menu_black)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun showThemeSelectDialog(){
        dialog = ThemeSelectDialog(this)
        dialog.show()
    }
}