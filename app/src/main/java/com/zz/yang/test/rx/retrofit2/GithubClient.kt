package com.zz.yang.test.rx.retrofit2

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**************************************************************************************
Rx 와 Retrofit2를 연계
 **************************************************************************************/
class GithubClient {
    companion object {
        private const val BASE_URL = "https://api.github.com"

        fun getApi(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            /*
            Retrofit 의 Call 이라는 Response 타입을 Rx의 Single 또는 Observable로 변한하기 위해서는
            addCallAdapterFactory(RxJava2CallAdapterFactory.create()) 를 사용해야 한다!
             */

            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}