package com.bj.ocean.mygankmeizi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bj.ocean.mygankmeizi.data.GirlRepository
import kotlinx.coroutines.launch

/**
 * Created by ocean on 2020-05-09
 * @describe:
 */
class GirlDetailViewModel(
    private val girlRepository: GirlRepository,
    private val girl_id: String
) : ViewModel(){
    val girl =girlRepository.getGirl(girl_id)
    val isFavor:Boolean =1==girl.value?.isFavor

    fun addGirlToFavor(){
        viewModelScope.launch {
            girlRepository.updateGirl(girl_id)
        }
    }

}