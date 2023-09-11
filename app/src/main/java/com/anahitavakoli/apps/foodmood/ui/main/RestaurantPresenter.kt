package com.anahitavakoli.apps.foodmood.ui.main

import com.anahitavakoli.apps.foodmood.api.ApiCaller
import com.anahitavakoli.apps.foodmood.model.IResponseMessage
import com.anahitavakoli.apps.foodmood.model.IView
import com.anahitavakoli.apps.foodmood.model.RestaurantModel

class RestaurantPresenter (iView: IView<RestaurantModel>): IResponseMessage<RestaurantModel> {

    val apiCaller = ApiCaller()
    var view: IView<RestaurantModel> = iView

    fun getRestaurant(){
        apiCaller.getRestaurants(this)
    }

    override fun onSuccess(responseMessage: RestaurantModel) {
        view.onSuccess(responseMessage)
    }

    override fun onFailure(error: String) {
        view.onError(error)
    }


}