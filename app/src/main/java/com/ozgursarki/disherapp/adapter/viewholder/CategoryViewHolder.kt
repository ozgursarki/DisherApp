package com.ozgursarki.disherapp.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.model.CategoryX

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind( category: CategoryX) {
        val title = itemView.findViewById<TextView>(R.id.Title)
        title.text = category.strCategory
    }
}