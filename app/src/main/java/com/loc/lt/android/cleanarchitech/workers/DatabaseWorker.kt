package com.loc.lt.android.cleanarchitech.workers

import android.content.Context
import android.util.JsonReader
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

//class SeedDatabaseWorker(
//    context: Context,
//    workerParams: WorkerParameters
//) : CoroutineWorker(context, workerParams) {
//    override suspend fun doWork(): Result = coroutineScope {
//        try {
///*
//            applicationContext.assets.open(PLANT_DATA_FILENAME).use { inputStream ->
//                JsonReader(inputStream.reader()).use { jsonReader ->
//                    val plantType = object : TypeToken<List<Plant>>() {}.type
//                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
//
//                    val database = AppDatabase.getInstance(applicationContext)
//                    database.plantDao().insertAll(plantList)
//
//                    Result.success()
//                }
//            }
//*/
//        } catch (ex: Exception) {
//            Log.e(TAG, "Error seeding database", ex)
//            Result.failure()
//        }
//    }
//
//    companion object {
//        private const val TAG = "SeedDatabaseWorker"
//    }
//}
