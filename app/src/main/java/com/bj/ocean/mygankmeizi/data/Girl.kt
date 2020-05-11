package com.bj.ocean.mygankmeizi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Created by ocean on 2020-04-30
 *
 * 数据源来源于 gankIo  https://gank.io/api
 * https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/100
 *
 * @describe:
 */
@Entity(tableName = "girls")
 data class Girl (
    @PrimaryKey @ColumnInfo(name = "id")
    val girl_id: String,
    val author: String,
    val category: String,
    val createdAt: String,
    val desc: String,
    val likeCounts: Int = 0,
    val publishedAt: String,
    val stars: Int = 0,
    val title: String,
    val type: String,
    val url: String,
    val views: Int = 0,
    val images: List<String>,
    var isFavor:Int=0  // 是否收藏，这样可以执行set get 方法
){

    override fun toString(): String {

        return super.toString()
    }




}
