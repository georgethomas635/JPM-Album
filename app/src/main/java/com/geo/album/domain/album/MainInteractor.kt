package com.geo.album.domain.album

import com.geo.album.domain.models.AlbumResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by George Thomas on 29/9/21
 */
interface MainInteractor {
    suspend fun getAlbumList(): Flow<ArrayList<AlbumResult>>
}