package com.anahitavakoli.apps.foodmood.model

import com.google.gson.annotations.SerializedName

data class FoodModel(
    @SerializedName("ONLINE_Book")
    val foods: List<Food>
)