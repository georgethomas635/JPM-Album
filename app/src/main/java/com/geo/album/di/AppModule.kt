package com.geo.album.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by George Thomas on 29/9/21
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @IoCoroutine
    @Provides
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}