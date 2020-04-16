package com.hoon.dustsearch.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hoon.dustsearch.data.remote.api.BaseApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiManager {

    val BASE_URL: String = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/"

    val CONNECT_TIMEOUT: Long = 15
    val WRITE_TIMEOUT: Long = 15
    val READ_TIMEOUT: Long = 15

    var okHttpClient: OkHttpClient
    var retrofit: Retrofit
    var baseApi: BaseApi

    init {

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        }.build()

        retrofit = Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            client(okHttpClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build()

        baseApi = retrofit.create()
    }
    fun getInstance(): BaseApi {
        return baseApi
    }
}
