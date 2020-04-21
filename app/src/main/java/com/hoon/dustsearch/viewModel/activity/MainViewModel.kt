package com.hoon.dustsearch.viewModel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hoon.dustsearch.base.BaseViewModel
import com.hoon.dustsearch.common.ApiConsts
import com.hoon.dustsearch.data.remote.ApiManager
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesureResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class MainViewModel: BaseViewModel() {

    val TAG = "MainViewModel"

    fun apiCtprvnMesureLIst() : LiveData<CtprvnMesureResponse> {

        val CtprvnMesureData: MutableLiveData<CtprvnMesureResponse> by lazy {
            MutableLiveData<CtprvnMesureResponse>()
        }

        ApiManager.getInstance().getCtprvnMesureLIst(
            "PM10",
            "DAILY",
            "MONTH",
            1,
            10,
            URLDecoder.decode(ApiConsts.API_SERVER_KEY,"UTF-8"),
            "json").enqueue(object : Callback<CtprvnMesureResponse> {
            override fun onResponse(call: Call<CtprvnMesureResponse>,
                                    response: Response<CtprvnMesureResponse>) {

                CtprvnMesureData.value = response.body()
            }

            override fun onFailure(call: Call<CtprvnMesureResponse>, t: Throwable) {}
        })
        return CtprvnMesureData
    }
}