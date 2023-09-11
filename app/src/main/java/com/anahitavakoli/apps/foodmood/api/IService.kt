package com.anahitavakoli.apps.foodmood.api

import com.anahitavakoli.apps.foodmood.model.CategoryModel
import com.anahitavakoli.apps.foodmood.model.FoodModel
import com.anahitavakoli.apps.foodmood.model.RestaurantModel
import retrofit2.Call
import retrofit2.http.GET

interface IService {

    @GET("api.php?cat_list")
    fun getCategories () : Call<CategoryModel>

    @GET("api.php?latest")
    fun getFoods(): Call<FoodModel>

    @GET("api.php?album_list")
    fun getRestaurant(): Call<RestaurantModel>

}