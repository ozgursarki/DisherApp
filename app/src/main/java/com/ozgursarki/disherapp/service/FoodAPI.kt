package com.ozgursarki.disherapp.service

import com.ozgursarki.disherapp.model.CategoryItem
import io.reactivex.Observable
import retrofit2.http.GET

interface FoodAPI {

    @GET("categories.php")
    fun GetCategories(): Observable<CategoryItem>
}