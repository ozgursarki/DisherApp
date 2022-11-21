package com.ozgursarki.disherapp.listener

import com.ozgursarki.disherapp.adapter.FoodListAdapter
import com.ozgursarki.disherapp.model.CategoryX
import com.ozgursarki.disherapp.model.Meal

interface ClickListener {
    fun clicked(category: CategoryX)
}

interface ClickListenerForMeal {

    fun clickedMeal (meal: Meal)

}