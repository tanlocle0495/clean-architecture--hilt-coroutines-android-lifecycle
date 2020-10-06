package com.loc.lt.android.cleanarchitech.di

import com.loc.lt.android.cleanarchitech.BuildConfig
import com.loc.lt.android.cleanarchitech.data.remote.AppApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideAppApi(okHttpClient: OkHttpClient, BASE_URL: String): AppApi {
        return AppApi.create(okHttpClient, BASE_URL)
    }
}