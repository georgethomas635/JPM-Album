package com.geo.album.service.album

import androidx.lifecycle.MutableLiveData
import com.geo.album.domain.album.MainRepository
import com.geo.album.domain.models.AlbumResult
import com.geo.album.service.db.AlbumDao
import com.geo.album.service.models.AlbumMapper
import javax.inject.Inject

/**
 * Created by George Thomas on 29/9/21
 */
class MainRepositoryImpl @Inject constructor(
    private val albumService: AlbumService,
    private val albumDao: AlbumDao
) : MainRepository {

    private val errorMessage = MutableLiveData<String>()

    /**
     * AlbumService is injected using hilt
     * getAlbumList() will fetch album list from server
     */
    override suspend fun getAlbumList(): ArrayList<AlbumResult> {
        var result = ArrayList<AlbumResult>()
        try {
            val albumResponse = albumService.getAlbumList()
            result = AlbumMapper().transform(albumResponse)
        } catch (throwable: Throwable) {
            errorMessage.postValue(throwable.message)
        }
        return result
    }

    override suspend fun getAlbumListFromDB(): ArrayList<AlbumResult> =
        albumDao.getAlbums() as ArrayList<AlbumResult>

    override suspend fun saveAlbumListToDB(albumList: ArrayList<AlbumResult>) =
        albumDao.insertAlbums(albumList)

    override fun getErrorDetails() = errorMessage

}