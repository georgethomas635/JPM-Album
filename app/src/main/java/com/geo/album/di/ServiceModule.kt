package com.geo.album.di

import com.geo.album.BuildConfig
import com.geo.album.data.AppDatabase
import com.geo.album.service.ApiBuilder
import com.geo.album.service.album.AlbumService
import com.geo.album.service.db.AlbumDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by George Thomas on 29/9/21
 */
@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideAlbumService(apiBuilder: ApiBuilder): AlbumService {
        return apiBuilder.getService(AlbumService::class.java)
    }

    @Provides
    fun provideAPIBuilder(): ApiBuilder {
        return ApiBuilder.getInstance(BuildConfig.BASE_URL)
    }

    @Provides
    fun provideProfileDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.albumDao()
    }
}