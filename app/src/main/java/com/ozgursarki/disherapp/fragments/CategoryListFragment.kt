package com.ozgursarki.disherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.adapter.CategoryListAdapter
import com.ozgursarki.disherapp.databinding.FragmentCategoryListBinding
import com.ozgursarki.disherapp.listener.ClickListener
import com.ozgursarki.disherapp.model.CategoryItem
import com.ozgursarki.disherapp.model.CategoryX
import com.ozgursarki.disherapp.service.FoodAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class CategoryListFragment : Fragment(), ClickListener{

    private lateinit var binding: FragmentCategoryListBinding
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable = CompositeDisposable()
        loadData()
        val list = listOf<String>("asda","asdafs","asdasdas","asdasd","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa","asdasdassa")

    }

    fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(FoodAPI::class.java)

        compositeDisposable?.add(retrofit.GetCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { model ->
                /*
                binding.recyclerview.adapter = CategoryListAdapter(model.categories, clicked = {
                    this.findNavController().navigate(R.id.action_categoryListFragment_to_foodListFragment)
                })


                 */
                val adapter = CategoryListAdapter(model.categories)
                binding.recyclerview.adapter = adapter
                adapter.setListener(this)

            })
    }

    override fun clicked(category: CategoryX) {
        //this.findNavController().navigate(R.id.action_categoryListFragment_to_foodListFragment)
        val action = CategoryListFragmentDirections.actionCategoryListFragmentToFoodListFragment(category)
        this.findNavController().navigate(action)
    }


}