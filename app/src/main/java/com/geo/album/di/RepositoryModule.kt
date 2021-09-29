package com.geo.album.di

import com.geo.album.domain.album.MainRepository
import com.geo.album.service.album.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by George Thomas on 29/9/21
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideMainRepository(repository: MainRepositoryImpl): MainRepository
}