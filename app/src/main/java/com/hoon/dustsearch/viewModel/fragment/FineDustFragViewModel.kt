package com.hoon.dustsearch.viewModel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hoon.dustsearch.base.BaseViewModel
import com.hoon.dustsearch.common.ApiConsts
import com.hoon.dustsearch.data.remote.ApiManager
import com.hoon.dustsearch.model.MsrstnAcctoRltmMesureDnsty.MsrstnAcctoRltmMesureDnstyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class FineDustFragViewModel: BaseViewModel() {

    val TAG = "FineDustFragViewModel"

    fun apiMsrstnAcctoRltmMesureDnstyList() : LiveData<MsrstnAcctoRltmMesureDnstyResponse> {

        val msrstnAcctoRltmMesureDnsty: MutableLiveData<MsrstnAcctoRltmMesureDnstyResponse> by lazy {
            MutableLiveData<MsrstnAcctoRltmMesureDnstyResponse>()
        }

        ApiManager.getInstance().getMsrstnAcctoRltmMesureDnstyList(
            "종로구",
            "month",
            1,
            10,
            URLDecoder.decode(ApiConsts.API_SERVER_KEY, "UTF-8"),
            "1.3",
            "json").enqueue(object : Callback<MsrstnAcctoRltmMesureDnstyResponse> {
            override fun onResponse(
                call: Call<MsrstnAcctoRltmMesureDnstyResponse>,
                response: Response<MsrstnAcctoRltmMesureDnstyResponse>) {

                msrstnAcctoRltmMesureDnsty.value = response.body()

            }

            override fun onFailure(call: Call<MsrstnAcctoRltmMesureDnstyResponse>, t: Throwable) {}
        })
        return msrstnAcctoRltmMesureDnsty
    }
}