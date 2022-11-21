package com.ozgursarki.disherapp.fragments.foodList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.adapter.FoodListAdapter
import com.ozgursarki.disherapp.databinding.FragmentFoodListBinding
import com.ozgursarki.disherapp.model.CategoryX
import com.ozgursarki.disherapp.model.FoodItem
import com.ozgursarki.disherapp.model.Meal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class FoodListViewModel(application: Application) : AndroidViewModel(application) {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()
    val mealList = MutableLiveData<List<Meal>>()


    fun loadFood(category: CategoryX) {
        val retrofit = Constant.getRetrofit()

        compositeDisposable?.add(retrofit.GetFood(category.strCategory)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Consumer<FoodItem> {
                override fun accept(t: FoodItem?) {
                    mealList.value = t?.meals
                }

            }))
    }

}






