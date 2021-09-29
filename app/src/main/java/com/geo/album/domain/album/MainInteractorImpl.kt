package com.geo.album.domain.album

import com.geo.album.domain.models.AlbumResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by George Thomas on 29/9/21
 */
class MainInteractorImpl @Inject constructor(val repository: MainRepository) : MainInteractor {
    override suspend fun getAlbumList(): Flow<ArrayList<AlbumResult>> {
        return flow {
            //TODO: set bd caching
            val albumList= repository.getAlbumList()
            emit(albumList)
        }
    }
}