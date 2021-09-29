package com.geo.album.service.album

import com.geo.album.service.APIConstants.ALBUM_API
import com.geo.album.service.models.AlbumResponse
import retrofit2.http.GET

/**
 * Created by George Thomas on 29/9/21
 */
interface AlbumService {

    @GET(ALBUM_API)
    suspend fun getAlbumList(): ArrayList<AlbumResponse>

}