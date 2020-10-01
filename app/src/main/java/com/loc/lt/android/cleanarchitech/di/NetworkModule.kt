package com.loc.lt.android.cleanarchitech.di

import com.loc.lt.android.cleanarchitech.data.remote.AppApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideAppApi(): AppApi {
        return AppApi.create()
    }

}