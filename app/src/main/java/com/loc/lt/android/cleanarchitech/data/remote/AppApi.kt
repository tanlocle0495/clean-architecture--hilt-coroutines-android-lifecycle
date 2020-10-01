package com.loc.lt.android.cleanarchitech.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface AppApi {

    companion object {
        fun create(): AppApi {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("BASE_URL")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AppApi::class.java)
        }
    }

}