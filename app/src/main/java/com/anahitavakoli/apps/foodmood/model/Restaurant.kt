package com.anahitavakoli.apps.foodmood.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    @SerializedName("aid")
    val rId: String,
    @SerializedName("album_image")
    val restaurantImage: String,
    @SerializedName("album_image_thumb")
    val restaurantImageThumb: String,
    @SerializedName("album_name")
    val restaurantName: String
):Parcelable