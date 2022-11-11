package com.ozgursarki.disherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.adapter.viewholder.FoodViewHolder
import com.ozgursarki.disherapp.model.Meal

class FoodListAdapter(val list: List<Meal>) : RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_row,parent,false)
        return FoodViewHolder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.enject(list[position])
    }
}