package com.geo.album.service.models

import com.geo.album.domain.models.AlbumResult

/**
 * Created by George Thomas on 29/9/21
 */
class AlbumMapper {
    fun transform(response: ArrayList<AlbumResponse>): ArrayList<AlbumResult> {
        val albumResult = ArrayList<AlbumResult>()
        if (response != null) {
            for (item in response) {
                albumResult.add(
                    AlbumResult(
                        id = item.id,
                        title = item.title
                    )
                )
            }
        }
        return albumResult
    }
}