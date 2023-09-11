package com.anahitavakoli.apps.foodmood.model

interface IResponseMessage<T> {

    fun onSuccess(responseMessage : T)
    fun onFailure(responseMessage : String)
}