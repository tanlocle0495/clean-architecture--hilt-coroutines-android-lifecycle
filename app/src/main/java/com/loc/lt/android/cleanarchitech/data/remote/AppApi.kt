package com.loc.lt.android.cleanarchitech.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface AppApi {

    companion object {
        fun create(okHttpClient: OkHttpClient, BASE_URL: String): AppApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AppApi::class.java)
        }
    }

}