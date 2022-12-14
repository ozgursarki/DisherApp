package com.ozgursarki.disherapp.service

import com.ozgursarki.disherapp.model.CategoryItem
import com.ozgursarki.disherapp.model.FoodItem
import com.ozgursarki.disherapp.model.TargetFood
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodAPI {

    @GET("categories.php")
    fun GetCategories(): Observable<CategoryItem>

    //filter.php?c=Seafood
    @GET("filter.php")
    fun GetFood(
        @Query("c", encoded = true) category: String
    ): Observable<FoodItem>

    @GET("lookup.php")
    fun getDetails(
        @Query("i", encoded = true) id : String
    ):Observable<TargetFood>

    //@GET("/example/")
    //    void getLocation(@Query(value="latlng", encoded=true) String latlng);

}
