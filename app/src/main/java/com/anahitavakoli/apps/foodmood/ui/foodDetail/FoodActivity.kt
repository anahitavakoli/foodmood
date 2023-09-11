package com.anahitavakoli.apps.foodmood.ui.foodDetail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anahitavakoli.apps.foodmood.databinding.ActivityFoodBinding
import com.anahitavakoli.apps.foodmood.model.Food

class FoodActivity : AppCompatActivity() {

    lateinit var binding: ActivityFoodBinding
    var food: Food ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        food = if(Build.VERSION.SDK_INT >= 33)
        {
            intent.getParcelableExtra("food",Food::class.java)
        }else{
            intent.getParcelableExtra<Food>("food")
        }

    }
}