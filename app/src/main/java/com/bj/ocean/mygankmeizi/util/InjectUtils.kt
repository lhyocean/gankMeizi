package com.bj.ocean.mygankmeizi.util

import android.content.Context
import com.bj.ocean.mygankmeizi.data.AppDataBase
import com.bj.ocean.mygankmeizi.data.GirlReposity
import com.bj.ocean.mygankmeizi.viewmodel.GirlDetailViewModelFacytory
import com.bj.ocean.mygankmeizi.viewmodel.GirlListViewModelFactory

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
object InjectUtils {


    private fun getGirlRepository(context: Context): GirlReposity {

        return GirlReposity.getInstance(
            AppDataBase.getInstance(context).girlDao()
        )
    }

    fun providerGirlListViewModelFactory(context: Context):
            GirlListViewModelFactory {

        val girlReposity = getGirlRepository(context)
        return GirlListViewModelFactory(girlReposity)
    }

    fun providerGirlDetailViewModelFractory(
        context: Context, girl_id: String
    ): GirlDetailViewModelFacytory {
        return GirlDetailViewModelFacytory(getGirlRepository(context), girl_id)
    }


}