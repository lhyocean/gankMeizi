package com.bj.ocean.mygankmeizi.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by ocean on 2020-04-30
 * @describe:  操作数据库工具接口
 */
@Dao
interface GirlDao {

    @Query("select * from girls order by id")
    fun  getAllGirl():LiveData<List<Girl>>

    @Query("select * from girls where isFavor =1 order by id")
    fun getFavorGirl():LiveData<List<Girl>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllGirl(girls:List<Girl>)

    @Query("select * from girls where id= :girlId")
    fun getGirl(girlId:String):LiveData<Girl>

    /**
     *   更新方法，此处没有使用updata 注解
     */
    @Query("update girls set isFavor =1 where id = :girl_id")
    suspend fun updateFavor(girl_id: String)


    /**
     *   更新方法，此处没有使用updata 注解
     */
    @Query("update girls set isFavor =0 where id = :girl_id")
    suspend fun cancelFavor(girl_id: String)





}