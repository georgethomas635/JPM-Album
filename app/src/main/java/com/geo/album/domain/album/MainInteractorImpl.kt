package com.geo.album.domain.album

import com.geo.album.domain.models.AlbumResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by George Thomas on 29/9/21
 */
class MainInteractorImpl @Inject constructor(private val repository: MainRepository) :
    MainInteractor {
    override suspend fun getAlbumList(): Flow<ArrayList<AlbumResult>> {
        return flow {
            /**
             * Fetch data from local Database
             */
            val albumListLocal = repository.getAlbumListFromDB()
            emit(albumListLocal)

            /**
             * Fetch album list from server
             */
            val albumList = repository.getAlbumList()
            albumList.sortBy { it.title }
            if (albumList.size > 0) {
                emit(albumList)
            }

            /**
             * Save album list in local database
             */
            repository.saveAlbumListToDB(albumList)
        }
    }

    /**
     * If API call failed getErrorMessage will share the error message to ViewModel
     */
    override fun getErrorMessage() = repository.getErrorDetails()
}