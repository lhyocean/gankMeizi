package com.bj.ocean.mygankmeizi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bj.ocean.mygankmeizi.data.Girl
import com.bj.ocean.mygankmeizi.data.GirlReposity

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
class GirlListViewModel internal constructor(

    girlReposity: GirlReposity
) : ViewModel() {
    val girls: LiveData<List<Girl>> = girlReposity.getGirls(false)
    val favor: LiveData<List<Girl>> = girlReposity.getGirls(true)




}