package com.ozgursarki.disherapp.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.model.CategoryX
import com.squareup.picasso.Picasso

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(category: CategoryX, clicked: (category: CategoryX) -> Unit) {
        val title = itemView.findViewById<TextView>(R.id.Title)
        val image = itemView.findViewById<ImageView>(R.id.imageView)

        Picasso.get().load(category.strCategoryThumb).into(image)

        title.text = category.strCategory

        title.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                clicked.invoke(category)
            }

        })



        /*
       title.setOnClickListener {

       }

        */
    }
}