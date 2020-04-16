package com.hoon.dustsearch.ui

import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.hoon.dustsearch.R
import com.hoon.dustsearch.base.BaseActivity
import com.hoon.dustsearch.common.ApiConsts
import com.hoon.dustsearch.data.remote.ApiManager

import com.hoon.dustsearch.databinding.ActivityMainBinding
import com.hoon.dustsearch.model.CtprvnMesureModel
import com.hoon.dustsearch.viewModel.MainViewModel
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.net.URLDecoder
import java.net.URLEncoder

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    val TAG = "MainActivity"

    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiManager.getInstance().getCtprvnMesureLIst(
            "PM10",
            "DAILY",
            "MONTH",
            1,
            10,
            URLDecoder.decode(ApiConsts.API_SERVER_KEY,"UTF-8"),
            "json").enqueue(object : Callback<CtprvnMesureModel> {
            override fun onResponse(call: Call<CtprvnMesureModel>,
                                    response: Response<CtprvnMesureModel>) {
                Log.e("가나다라", ""+response.body())
                Log.e("가나다라마바사", response.body()?.list)
            }
            override fun onFailure(call: Call<CtprvnMesureModel>, t: Throwable) {
                Log.e("가나다라마바사아자차카타파하", t.message)
            }
        })

    }
}
