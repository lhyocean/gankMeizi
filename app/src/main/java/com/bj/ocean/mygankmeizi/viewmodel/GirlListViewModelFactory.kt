package com.bj.ocean.mygankmeizi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bj.ocean.mygankmeizi.data.GirlRepository

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
class GirlListViewModelFactory(private val girlRepository: GirlRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GirlListViewModel(girlRepository) as T
    }
}