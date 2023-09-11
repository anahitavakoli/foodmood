package com.anahitavakoli.apps.foodmood.model

import com.google.gson.annotations.SerializedName

data class RestaurantModel(
    @SerializedName("ONLINE_Book")
    val restaurants: List<Restaurant>
)