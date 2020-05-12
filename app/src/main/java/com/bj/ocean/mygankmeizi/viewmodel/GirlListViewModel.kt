package com.bj.ocean.mygankmeizi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.data.GirlRepository

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
class GirlListViewModel internal constructor(

    girlRepository: GirlRepository
) : ViewModel() {
    val girls: LiveData<List<Girl>> = girlRepository.getGirls(false)
    val favor: LiveData<List<Girl>> = girlRepository.getGirls(true)




}