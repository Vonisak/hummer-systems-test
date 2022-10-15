package com.vonisak.dodo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vonisak.dodo.domain.entity.Banner
import com.vonisak.dodo.domain.entity.Category
import com.vonisak.dodo.domain.entity.Dish
import com.vonisak.dodo.domain.usecase.GetBannersUseCase
import com.vonisak.dodo.domain.usecase.GetCategoriesUseCase
import com.vonisak.dodo.domain.usecase.GetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzeriaViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getDishesUseCase: GetDishesUseCase,
    private val getBannersUseCase: GetBannersUseCase
): ViewModel() {

    private val _dishesLiveData = MutableLiveData<List<Dish>>()
    val dishesLiveData: LiveData<List<Dish>> = _dishesLiveData

    private val _categoriesLiveData = MutableLiveData<List<Category>>()
    val categoriesLiveData: LiveData<List<Category>> = _categoriesLiveData

    private val _bannersLiveData = MutableLiveData<List<Banner>>()
    val bannersLiveData: LiveData<List<Banner>> = _bannersLiveData

    fun getDishes() {
        CoroutineScope(Dispatchers.IO).launch {

            val categoryCount = getCategoriesUseCase().size
            val dishes = mutableListOf<Dish>()
            for (i in (1..categoryCount)) {
                dishes.addAll(getDishesUseCase(i))
            }
            _dishesLiveData.postValue(dishes.toList())
        }
    }

    fun getCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val categories = getCategoriesUseCase()
            _categoriesLiveData.postValue(categories)
        }
    }

    fun getBanners() {
        CoroutineScope(Dispatchers.IO).launch {
            val banners = getBannersUseCase()
            _bannersLiveData.postValue(banners)
        }
    }
}