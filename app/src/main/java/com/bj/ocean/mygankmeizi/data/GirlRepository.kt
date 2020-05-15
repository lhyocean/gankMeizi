package com.bj.ocean.mygankmeizi.data

import androidx.lifecycle.LiveData

/**
 * Created by ocean on 2020-04-30
 * @describe:
 */
class GirlRepository private constructor(private val girlDao: GirlDao) {

    //
    fun getGirls(isFavor: Boolean): LiveData<List<Girl>> =
        if (isFavor)
            girlDao.getFavorGirl()
        else
            girlDao.getAllGirl()

    fun getGirl(_id: String) = girlDao.getGirl(_id)

    suspend fun updateGirl(girl_id: String){
        girlDao.updateFavor(girl_id)
    }

    suspend fun cancelFavorGirl(girl_id: String){
        girlDao.cancelFavor(girl_id)
    }

    companion object {
        @Volatile
        private var instance: GirlRepository? = null

        fun getInstance(girlDao: GirlDao) =
            instance ?: synchronized(this) {
                instance ?: GirlRepository(girlDao).also { instance = it }
            }

    }


}