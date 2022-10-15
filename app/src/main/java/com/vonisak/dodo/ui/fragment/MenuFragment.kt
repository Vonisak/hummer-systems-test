package com.vonisak.dodo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vonisak.dodo.databinding.FragmentMenuBinding
import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.presentation.viewmodel.PizzeriaViewModel
import com.vonisak.dodo.ui.activity.MainActivity
import com.vonisak.dodo.ui.adapter.BannerAdapter
import com.vonisak.dodo.ui.adapter.DishAdapter
import com.vonisak.dodo.ui.adapter.GlideAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PizzeriaViewModel by viewModels()
    private val glideAdapter = GlideAdapter(this)
    private val bannerAdapter = BannerAdapter(glideAdapter) {
        Toast.makeText(requireContext(), "banner id: $it", Toast.LENGTH_SHORT).show()
    }
    private val dishAdapter = DishAdapter(glideAdapter)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        viewModel.getDishes()
        viewModel.getBanners()
        setRecyclers()
        observeModel()
        return binding.root
    }

    private fun observeModel() {
        viewModel.dishesLiveData.observe(viewLifecycleOwner) { dishes ->
            dishAdapter.dishes = dishes
        }
        viewModel.bannersLiveData.observe(viewLifecycleOwner) { banners ->
            bannerAdapter.banners = banners
        }
    }

    private fun setRecyclers() {
        binding.banners.recycler.adapter = bannerAdapter
        binding.dishesRecycler.adapter = dishAdapter

        binding.dishesRecycler.setOnScrollChangeListener { _, _, _, _, _ ->
            val currentPos =
                (binding.dishesRecycler.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            if (dishAdapter.dishes[currentPos].categoryId == 1) {
                binding.categories.chip1.isChecked = true
            } else if (dishAdapter.dishes[currentPos].categoryId == 2) {
                binding.categories.chip2.isChecked = true
            } else if (dishAdapter.dishes[currentPos].categoryId == 3) {
                binding.categories.chip3.isChecked = true
            } else {
                binding.categories.chip4.isChecked = true
            }
        }
    }
}