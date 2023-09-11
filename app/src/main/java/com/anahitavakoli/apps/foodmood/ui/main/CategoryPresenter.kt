package com.anahitavakoli.apps.foodmood.ui.main

import com.anahitavakoli.apps.foodmood.api.ApiCaller
import com.anahitavakoli.apps.foodmood.model.CategoryModel
import com.anahitavakoli.apps.foodmood.model.IResponseMessage
import com.anahitavakoli.apps.foodmood.model.IView

class CategoryPresenter(iView: IView<CategoryModel>): IResponseMessage<CategoryModel> {

    val apiCaller = ApiCaller()
    var view: IView<CategoryModel> = iView

    fun getCategories(){
        view.showProgressBar()
        apiCaller.getCategories(this)
    }

    override fun onSuccess(responseMessage: CategoryModel) {
        view.hideProgressBar()
        view.onSuccess(responseMessage)
    }

    override fun onFailure(error: String) {
        view.hideProgressBar()
        view.onError(error)
    }
}