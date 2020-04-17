package com.hoon.dustsearch.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseActivity

import com.hoon.dustsearch.databinding.ActivitySplashBinding
import com.hoon.dustsearch.viewModel.MainViewModel
import com.hoon.dustsearch.viewModel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    val TAG = "SplashActivity"

    override val layoutResourceId: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel = SplashViewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

        Handler().postDelayed(Runnable {
            kotlin.run {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
