package com.ozgursarki.disherapp.fragments.categoryList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.adapter.CategoryListAdapter
import com.ozgursarki.disherapp.model.CategoryX
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryListViewModel(application: Application): AndroidViewModel(application) {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()
    val categoryList = MutableLiveData<List<CategoryX>>()

    fun getCategoryData(){
        val retrofit = Constant.getRetrofit()

        compositeDisposable?.add(retrofit.GetCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { model ->
                categoryList.value = model.categories





            })
    }
}