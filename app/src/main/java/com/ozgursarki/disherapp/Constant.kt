package com.ozgursarki.disherapp

import com.ozgursarki.disherapp.service.FoodAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Constant {
    val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
    private var instance: FoodAPI? = null
    fun getRetrofit(): FoodAPI {

        return if (instance == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constant.baseUrl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(FoodAPI::class.java)
            instance = retrofit
            retrofit
        } else {
            instance!!
        }
    }
}