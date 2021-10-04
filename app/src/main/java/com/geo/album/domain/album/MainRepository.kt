package com.geo.album.domain.album

import androidx.lifecycle.MutableLiveData
import com.geo.album.domain.models.AlbumResult

/**
 * Created by George Thomas on 29/9/21
 */
interface MainRepository {
    suspend fun getAlbumList(): ArrayList<AlbumResult>

    suspend fun getAlbumListFromDB(): ArrayList<AlbumResult>

    suspend fun saveAlbumListToDB(albumList: ArrayList<AlbumResult>)

    fun getErrorDetails() : MutableLiveData<String>
}