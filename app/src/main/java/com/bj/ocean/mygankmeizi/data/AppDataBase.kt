package com.bj.ocean.mygankmeizi.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bj.ocean.mygankmeizi.util.DB_NAME
import com.bj.ocean.mygankmeizi.worker.DataWorker
import java.lang.StringBuilder

/**
 * Created by ocean on 2020-04-30
 * @describe:
 */

@Database(entities = [Girl::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun girlDao(): GirlDao

    companion object {
        private fun buildDataBase(context: Context): AppDataBase =

            Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<DataWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)

                    }
                })
                .build()

        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also { instance = it }
            }
        }
    }
}

class Converters {
    @TypeConverter
    fun listToString(list: List<String>): String {
        var str: StringBuilder = StringBuilder()
        list?.apply {
            if (!isNullOrEmpty()) {
                for (s in this) {
                    str.append(s).append(",")
                }
            }
        }
        return str.toString()
    }

    @TypeConverter
    fun StringToLsit(string: String): List<String> {
        var list = emptyList<String>()
        if (!string.isNullOrEmpty()) {
            list = string.split(",")
        }
        return list

    }

}