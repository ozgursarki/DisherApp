package com.ozgursarki.disherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.adapter.viewholder.CategoryViewHolder
import com.ozgursarki.disherapp.listener.ClickListener
import com.ozgursarki.disherapp.model.CategoryX

class CategoryListAdapter(var list: List<CategoryX>) : RecyclerView.Adapter<CategoryViewHolder>() {

    private lateinit var listener: ClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position]) {
            listener.clicked(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setListener(clickListener: ClickListener) {
        listener = clickListener
    }


    fun setCategoryList(newList:List<CategoryX>) {

        this.list = newList
        notifyDataSetChanged()


    }
}