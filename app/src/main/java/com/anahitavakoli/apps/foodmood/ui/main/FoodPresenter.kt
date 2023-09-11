package com.anahitavakoli.apps.foodmood.ui.main

import com.anahitavakoli.apps.foodmood.api.ApiCaller
import com.anahitavakoli.apps.foodmood.model.FoodModel
import com.anahitavakoli.apps.foodmood.model.IResponseMessage
import com.anahitavakoli.apps.foodmood.model.IView

class FoodPresenter(iView: IView<FoodModel>):IResponseMessage<FoodModel> {

    val apiCaller = ApiCaller()
    var view: IView<FoodModel> = iView

    fun getFoods(){
        apiCaller.getFoods(this)
    }

    override fun onSuccess(responseMessage: FoodModel) {
        view.onSuccess(responseMessage)
    }

    override fun onFailure(error: String) {
        view.onError(error)
    }


}