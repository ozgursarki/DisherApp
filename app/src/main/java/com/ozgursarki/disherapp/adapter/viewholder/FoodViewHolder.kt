package com.ozgursarki.disherapp.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.model.Meal
import com.squareup.picasso.Picasso

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun enject(item : Meal, hof2: (Meal) -> Unit ){
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.Title)

        Picasso.get().load(item.strMealThumb).into(image)
        title.text = item.strMeal
        title.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                hof2.invoke(item)
            }

        })
    }
}