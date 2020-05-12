package com.bj.ocean.mygankmeizi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bj.ocean.mygankmeizi.data.GirlRepository

/**
 * Created by ocean on 2020-05-09
 * @describe:
 */
class GirlDetailViewModelFacytory(

    private val girlRepository: GirlRepository, private val girl_id: String

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GirlDetailViewModel(girlRepository, girl_id) as T
    }
}