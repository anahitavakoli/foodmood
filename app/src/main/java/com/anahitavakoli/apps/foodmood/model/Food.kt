package com.anahitavakoli.apps.foodmood.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    @SerializedName("book_description")
    val book_description: String,
    @SerializedName("book_numbers")
    val book_numbers: String,
    @SerializedName("book_publisher")
    val book_publisher: String,
    @SerializedName("book_thumbnail_b")
    val book_thumbnail_b: String,
    @SerializedName("book_thumbnail_s")
    val book_thumbnail_s: String,
    @SerializedName("book_title")
    val book_title: String,
    @SerializedName("book_type")
    val book_type: String,
    @SerializedName("book_url")
    val book_url: String,
    @SerializedName("cat_id")
    val cat_id: String,
    @SerializedName("category_image")
    val category_image: String,
    @SerializedName("category_image_thumb")
    val category_image_thumb: String,
    @SerializedName("category_name")
    val category_name: String,
    @SerializedName("cid")
    val cid: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("rate_avg")
    val rate_avg: String,
    @SerializedName("total_download")
    val total_download: String,
    @SerializedName("total_rate")
    val total_rate: String,
    @SerializedName("total_views")
    val total_views: String
):Parcelable