package com.ozgursarki.disherapp.fragments.FoodDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.databinding.FragmentFoodDetailBinding
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private lateinit var viewmodel : FoodDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(this)[FoodDetailViewModel::class.java]

        val args : FoodDetailFragmentArgs by navArgs()
        val item = args.details

        viewmodel.getDetails(item.idMeal)

        viewmodel.detailLive.observe(viewLifecycleOwner
        ) {
            val foodDetail = it.meals[0]
            Picasso.get().load(foodDetail.strMealThumb).into(binding.FoodImage)
            binding.FoodName.text = foodDetail.strMeal
            binding.malzeme1.text = foodDetail.strIngredient1
            binding.malzeme2.text = foodDetail.strIngredient2
            binding.link.text = foodDetail.strYoutube
            binding.talimat.text = foodDetail.strInstructions


        }


    }



}