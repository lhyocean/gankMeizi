package com.bj.ocean.mygankmeizi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bj.ocean.mygankmeizi.data.GirlReposity
import kotlinx.coroutines.launch

/**
 * Created by ocean on 2020-05-09
 * @describe:
 */
class GirlDetailViewModel(
    private val girlReposity: GirlReposity,
    private val girl_id: String
) : ViewModel(){
    val girl =girlReposity.getGirl(girl_id)
    val isFavor:Boolean =1==girl.value?.isFavor

    fun addGirlToFavor(){
        viewModelScope.launch {
            girlReposity.updateGirl(girl_id)
        }
    }

}