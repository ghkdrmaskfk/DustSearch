package com.hoon.dustsearch.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.common.ApiConsts
import com.hoon.dustsearch.data.remote.ApiManager

import com.hoon.dustsearch.databinding.ActivityMainBinding
import com.hoon.dustsearch.model.CtprvnMesureResponse
import com.hoon.dustsearch.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    val TAG = "MainActivity"

    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel = MainViewModel()

    override fun initStartView() {

        //View Model이 할 일 재 정의 필요

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation_view) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.search_item

//        ApiManager.getInstance().getCtprvnMesureLIst(
//            "PM10",
//            "DAILY",
//            "MONTH",
//            1,
//            10,
//            URLDecoder.decode(ApiConsts.API_SERVER_KEY,"UTF-8"),
//            "json").enqueue(object : Callback<CtprvnMesureResponse> {
//            override fun onResponse(call: Call<CtprvnMesureResponse>,
//                                    response: Response<CtprvnMesureResponse>) {
//
//            }
//
//            override fun onFailure(call: Call<CtprvnMesureResponse>, t: Throwable) {
//
//            }
//        })
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.search_item ->{
                Log.w("onOptionsItemSelected","1")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentA()).commit()
            } R.id.camera_item -> {
                Log.w("onOptionsItemSelected","2")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentB()).commit()
            } R.id.call_item -> {
                Log.w("onOptionsItemSelected","3")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentC()).commit()
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
