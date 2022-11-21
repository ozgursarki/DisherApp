package com.ozgursarki.disherapp.fragments.FoodDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.databinding.FragmentFoodDetailBinding
import com.ozgursarki.disherapp.model.TargetFood
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FoodDetailViewModel(application: Application) : AndroidViewModel(application) {
        var detailLive = MutableLiveData<TargetFood>()

    fun getDetails(id:String){
        val retrofit = Constant.getRetrofit()

        retrofit.getDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
               detailLive.value = it
            }
    }


}