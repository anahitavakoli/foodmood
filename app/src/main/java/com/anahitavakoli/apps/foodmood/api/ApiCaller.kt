package com.anahitavakoli.apps.foodmood.api

import com.anahitavakoli.apps.foodmood.model.CategoryModel
import com.anahitavakoli.apps.foodmood.model.FoodModel
import com.anahitavakoli.apps.foodmood.model.IResponseMessage
import com.anahitavakoli.apps.foodmood.model.RestaurantModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {

    var iService : IService = ApiService.retrofit.create(IService::class.java)

    fun getCategories(listener: IResponseMessage<CategoryModel>){
        iService.getCategories().enqueue(object: Callback<CategoryModel>{
            override fun onResponse(call: Call<CategoryModel>, response: Response<CategoryModel>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<CategoryModel>, t: Throwable) {
                listener.onFailure("Error in category receiver")
            }

        })
    }

    fun getFoods(listener: IResponseMessage<FoodModel>){

        iService.getFoods().enqueue(object: Callback<FoodModel>{
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<FoodModel>, t: Throwable) {
                listener.onFailure("Error in food receiver")
            }

        })

    }

    fun getRestaurants(listener: IResponseMessage<RestaurantModel>){

        iService.getRestaurant().enqueue(object: Callback<RestaurantModel>{
            override fun onResponse(call: Call<RestaurantModel>, response: Response<RestaurantModel>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                listener.onFailure("Error in restaurant receiver")
            }

        })

    }

}