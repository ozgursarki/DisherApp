package com.ozgursarki.disherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.databinding.FragmentFoodDetailBinding
import com.ozgursarki.disherapp.model.FoodItem
import com.ozgursarki.disherapp.service.FoodAPI
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : FoodDetailFragmentArgs by navArgs()
        val item = args.details
        print("")

        getDetails(item.idMeal)
    }

    fun getDetails(id:String){
        val retrofit = Constant.getRetrofit()

        retrofit.getDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val food = it.meals[0]
                //Picasso.get().load(food.strMealThumb).into(binding.FoodImage)
                binding.FoodName.text = food.strMeal
                binding.malzeme1.text = food.strIngredient1
                binding.malzeme2.text = food.strIngredient2
                binding.link.text = food.strYoutube
                binding.talimat.text = food.strInstructions
            }
    }

}