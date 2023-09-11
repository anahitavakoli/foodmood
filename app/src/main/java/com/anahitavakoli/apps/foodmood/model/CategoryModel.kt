package com.anahitavakoli.apps.foodmood.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("ONLINE_Book")
    val categories: List<Category>
)