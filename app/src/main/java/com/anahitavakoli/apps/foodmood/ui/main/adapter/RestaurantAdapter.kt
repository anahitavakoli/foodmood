package com.anahitavakoli.apps.foodmood.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anahitavakoli.apps.foodmood.R
import com.anahitavakoli.apps.foodmood.model.Restaurant
import com.anahitavakoli.apps.foodmood.ui.restaurantDetail.RestaurantActivity

class RestaurantAdapter(cContext: Context, data: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantVH>() {

    var context = cContext
    var restaurants = data


    class RestaurantVH(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgRestaurant: AppCompatImageView = itemView.findViewById(R.id.img_restaurant)
        var txtTitle: AppCompatTextView = itemView.findViewById(R.id.txt_title_restaurant)
        var restaurantCard: CardView = itemView.findViewById(R.id.restaurant_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantVH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.restaurant_row,null)
        return RestaurantVH(view)
    }

    override fun onBindViewHolder(holder: RestaurantVH, position: Int) {

        var restaurant = restaurants[position]
        holder.txtTitle.text = restaurant.restaurantName
        holder.imgRestaurant.load(restaurant.restaurantImage)

        holder.restaurantCard.setOnClickListener {
            val intent = Intent(context, RestaurantActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("restaurant", restaurant)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}