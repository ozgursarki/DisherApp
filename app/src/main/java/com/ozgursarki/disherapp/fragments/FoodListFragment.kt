package com.ozgursarki.disherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.adapter.FoodListAdapter
import com.ozgursarki.disherapp.databinding.FragmentFoodListBinding
import com.ozgursarki.disherapp.model.CategoryX
import com.ozgursarki.disherapp.model.FoodItem
import com.ozgursarki.disherapp.model.Meal
import com.ozgursarki.disherapp.service.FoodAPI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FoodListFragment : Fragment() {

    private lateinit var binding: FragmentFoodListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: FoodListFragmentArgs by navArgs()
        val item = args.categoryItem

        loadFood(item)
    }

    fun loadFood(item: CategoryX) {
        val retrofit = Constant.getRetrofit()

        retrofit.GetFood(item.strCategory)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Consumer<FoodItem> {
                override fun accept(t: FoodItem?) {
                    val adapter = FoodListAdapter(t!!.meals) {

                        val action = FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(it)
                        this@FoodListFragment.findNavController().navigate(action)

                    }
                    binding.recyclerview.adapter = adapter
                }

            })

    }
}

