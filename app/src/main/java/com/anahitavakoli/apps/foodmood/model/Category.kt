package com.anahitavakoli.apps.foodmood.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_image")
    val category_image: String,
    @SerializedName("category_image_thumb")
    val category_image_thumb: String,
    @SerializedName("category_name")
    val category_name: String,
    @SerializedName("cid")
    val cid: String
)