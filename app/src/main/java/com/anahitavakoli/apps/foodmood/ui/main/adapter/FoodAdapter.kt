package com.anahitavakoli.apps.foodmood.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anahitavakoli.apps.foodmood.R
import com.anahitavakoli.apps.foodmood.model.Food
import com.anahitavakoli.apps.foodmood.ui.foodDetail.FoodActivity

class FoodAdapter(cContext: Context, data: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodVH>() {

    var context = cContext
    var foods = data


    class FoodVH(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgFood = itemView.findViewById<AppCompatImageView>(R.id.img_food)
        var txtTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title_food)
        var rateFood = itemView.findViewById<AppCompatRatingBar>(R.id.rate_food)
        var foodCard = itemView.findViewById<CardView>(R.id.card_food)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.food_row,null)
        return FoodVH(view)
    }

    override fun onBindViewHolder(holder: FoodVH, position: Int) {

        var food = foods.get(position)
        holder.txtTitle.setText(food.book_title)
        holder.imgFood.load(food.book_thumbnail_b)
        holder.rateFood.rating = food.rate_avg.toFloat()

        holder.foodCard.setOnClickListener {
            val intent = Intent(context, FoodActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("food", food)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}