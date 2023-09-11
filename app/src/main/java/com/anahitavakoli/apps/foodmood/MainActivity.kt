package com.anahitavakoli.apps.foodmood

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anahitavakoli.apps.foodmood.config.AppConfig
import com.anahitavakoli.apps.foodmood.databinding.ActivityMainBinding
import com.anahitavakoli.apps.foodmood.model.CategoryModel
import com.anahitavakoli.apps.foodmood.model.FoodModel
import com.anahitavakoli.apps.foodmood.model.IView
import com.anahitavakoli.apps.foodmood.model.RestaurantModel
import com.anahitavakoli.apps.foodmood.ui.main.CategoryPresenter
import com.anahitavakoli.apps.foodmood.ui.main.FoodPresenter
import com.anahitavakoli.apps.foodmood.ui.main.RestaurantPresenter
import com.anahitavakoli.apps.foodmood.ui.main.adapter.CategoryAdapter
import com.anahitavakoli.apps.foodmood.ui.main.adapter.FoodAdapter
import com.anahitavakoli.apps.foodmood.ui.main.adapter.RestaurantAdapter

class MainActivity : AppCompatActivity() , IView<Any> {


    lateinit var binding: ActivityMainBinding
    lateinit var presenterCat: CategoryPresenter
    lateinit var presenterFood: FoodPresenter
    lateinit var presenterRestaurant: RestaurantPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppConfig.applicationContext()

        presenterCat = CategoryPresenter(this)
        presenterCat.getCategories()

        presenterFood = FoodPresenter(this)
        presenterFood.getFoods()

        presenterRestaurant = RestaurantPresenter(this)
        presenterRestaurant.getRestaurant()

    }


    override fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressbar.visibility = View.GONE
    }

    override fun onSuccess(responseMessage: Any) {

        when(responseMessage){
            is CategoryModel -> {
                Toast.makeText(applicationContext,"Good!",Toast.LENGTH_LONG).show()
                binding.recyclerFoodCategory.adapter = CategoryAdapter(applicationContext,responseMessage.categories)
                binding.recyclerFoodCategory.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            }

            is FoodModel ->{
                binding.recyclerNewFood.adapter = FoodAdapter(applicationContext,responseMessage.foods)
                binding.recyclerNewFood.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            }

            is RestaurantModel ->{
                binding.recyclerRestaurant.adapter = RestaurantAdapter(applicationContext,responseMessage.restaurants)
                binding.recyclerRestaurant.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            }

        }

    }

    override fun onError(responseMessage: String) {
        Toast.makeText(applicationContext,"Error!",Toast.LENGTH_LONG).show()
    }
}