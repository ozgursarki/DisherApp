package com.ozgursarki.disherapp.fragments.categoryList




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ozgursarki.disherapp.Constant
import com.ozgursarki.disherapp.adapter.CategoryListAdapter
import com.ozgursarki.disherapp.databinding.FragmentCategoryListBinding
import com.ozgursarki.disherapp.listener.ClickListener
import com.ozgursarki.disherapp.model.CategoryX
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CategoryListFragment : Fragment(), ClickListener{

    private lateinit var binding: FragmentCategoryListBinding
    private lateinit var viewModel: CategoryListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CategoryListAdapter(listOf())
        binding.recyclerview.adapter = adapter
        adapter.setListener(this)

        viewModel = ViewModelProvider(this).get(CategoryListViewModel::class.java)

        getCategories()
        viewModel.categoryList.observe(viewLifecycleOwner) {
            adapter.setCategoryList(it)

        }
    }

    fun getCategories() {
        viewModel.getCategoryData()
    }



    override fun clicked(category: CategoryX) {
        //this.findNavController().navigate(R.id.action_categoryListFragment_to_foodListFragment)
        val action = CategoryListFragmentDirections.actionCategoryListFragmentToFoodListFragment(category)
        this.findNavController().navigate(action)
    }


}