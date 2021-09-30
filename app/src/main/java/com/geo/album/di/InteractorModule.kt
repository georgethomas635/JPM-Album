package com.geo.album.di

import com.geo.album.domain.album.MainInteractor
import com.geo.album.domain.album.MainInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by George Thomas on 29/9/21
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {
    @Binds
    abstract fun provideMainInteractor(repository: MainInteractorImpl): MainInteractor
}