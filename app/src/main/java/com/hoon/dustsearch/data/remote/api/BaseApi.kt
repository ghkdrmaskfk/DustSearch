package com.hoon.dustsearch.data.remote.api

import com.hoon.dustsearch.model.CtprvnMesureModel
import retrofit2.Call
import retrofit2.http.*

interface BaseApi {

    @GET("getCtprvnMesureLIst")
    fun getCtprvnMesureLIst(@Query("itemCode") itemCode : String,
                            @Query("dataGubun") dataGubun : String,
                            @Query("searchCondition") searchCondition : String,
                            @Query("pageNo") pageNo : Int,
                            @Query("numOfRows") numOfRows : Int,
                            @Query("ServiceKey") ServiceKey : String,
                            @Query("_returnType") returnType : String) : Call<CtprvnMesureModel>
}