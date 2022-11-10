package com.ozgursarki.disherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozgursarki.disherapp.R
import com.ozgursarki.disherapp.databinding.FragmentFoodListBinding


class FoodListFragment : Fragment() {

    private lateinit var binding: FragmentFoodListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: FoodListFragmentArgs by navArgs()
        val item = args.categoryItem

        binding.description.text = item.strCategoryDescription


    }

}