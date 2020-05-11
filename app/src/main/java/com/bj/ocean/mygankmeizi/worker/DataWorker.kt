package com.bj.ocean.mygankmeizi.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bj.ocean.mygankmeizi.util.GIRL_ASSETS_NAME
import com.bj.ocean.mygankmeizi.data.AppDataBase
import com.bj.ocean.mygankmeizi.data.Girl
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

/**
 * Created by ocean on 2020-04-30
 * @describe:
 */
class DataWorker(
    context: Context, workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(GIRL_ASSETS_NAME).use {
                JsonReader(it.reader()).use {

                    val type = object : TypeToken<List<Girl>>() {}.type
                    val list: List<Girl> = Gson().fromJson(it, type)
                    val dataBase = AppDataBase.getInstance(applicationContext)
                    dataBase.girlDao().insertAllGirl(list)
                    Result.success()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }


    }
}