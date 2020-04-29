package com.hoon.dustsearch.ui.activity

import android.content.Intent
import android.os.Handler
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.databinding.ActivitySplashBinding
import com.hoon.dustsearch.viewModel.activity.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    val TAG = "SplashActivity"
    val START_DELAYED_TIME: Long = 2000

    override val layoutResourceId: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel =
        SplashViewModel()

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
        }, START_DELAYED_TIME)
    }
}
