package com.anahitavakoli.apps.foodmood.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anahitavakoli.apps.foodmood.R
import com.anahitavakoli.apps.foodmood.model.Category

class CategoryAdapter(cContext: Context, data: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    var context = cContext
    var categories = data


    class CategoryVH(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgCategory = itemView.findViewById<AppCompatImageView>(R.id.img_cat)
        var txtTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title_cat)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.category_row,null)
        return CategoryVH(view)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {

        var category = categories.get(position)
        holder.txtTitle.setText(category.category_name)
        holder.imgCategory.load(category.category_image)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}