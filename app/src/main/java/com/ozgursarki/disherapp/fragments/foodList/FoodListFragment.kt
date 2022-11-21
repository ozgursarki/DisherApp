package com.ozgursarki.disherapp.fragments.foodList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.adapter.FoodListAdapter
import com.ozgursarki.disherapp.databinding.FragmentFoodDetailBinding
import com.ozgursarki.disherapp.databinding.FragmentFoodListBinding
import com.ozgursarki.disherapp.listener.ClickListener
import com.ozgursarki.disherapp.listener.ClickListenerForMeal
import com.ozgursarki.disherapp.model.CategoryX
import com.ozgursarki.disherapp.model.FoodItem
import com.ozgursarki.disherapp.model.Meal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class FoodListFragment : Fragment(), ClickListenerForMeal {

    private lateinit var viewModel: FoodListViewModel
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

        viewModel = ViewModelProvider(this).get(FoodListViewModel::class.java)

        val adapter = FoodListAdapter(listOf())


        viewModel.mealList.observe(viewLifecycleOwner,{
            adapter.setAdapterList(it)
        })


        binding.recyclerview.adapter = adapter
        adapter.setListener(this)

        val args: FoodListFragmentArgs by navArgs()
        val item = args.categoryItem

        viewModel.loadFood(item)
    }


    override fun clickedMeal(meal: Meal) {
        val action = FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(meal)
        this.findNavController().navigate(action)
    }



}

