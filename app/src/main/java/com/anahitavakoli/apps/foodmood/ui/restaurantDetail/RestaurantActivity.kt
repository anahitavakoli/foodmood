package com.anahitavakoli.apps.foodmood.ui.restaurantDetail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.anahitavakoli.apps.foodmood.databinding.ActivityRestaurantBinding
import com.anahitavakoli.apps.foodmood.model.Restaurant

class RestaurantActivity : AppCompatActivity() {

    lateinit var binding: ActivityRestaurantBinding
    var restaurant: Restaurant?= null
    lateinit var bundle : Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras!!
        restaurant = if(Build.VERSION.SDK_INT >= 33)
        {
            intent.getParcelableExtra("restaurant",Restaurant::class.java)
        }else{
            intent.getParcelableExtra<Restaurant>("restaurant")
        }

        binding.imgRestaurant.load(restaurant!!.restaurantImage)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(RestaurantMenueFragment(), "Menue")
        adapter.addFragment(RestaurantCommentsFragment(), "Comments")
        adapter.addFragment(RestaurantInfoFragment(), "Information")

        // Adding the Adapter to the ViewPager
        binding.viewPager.adapter = adapter

        // bind the viewPager with the TabLayout.
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}