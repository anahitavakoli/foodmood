package com.anahitavakoli.apps.foodmood.model

interface IView<in T> {

    fun showProgressBar()
    fun hideProgressBar()
    fun onSuccess(responseMessage: T)
    fun onError(responseMessage: String)
}