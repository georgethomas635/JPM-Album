package com.geo.album.service.models

import com.google.gson.annotations.SerializedName

/**
 * Created by George Thomas on 29/9/21
 */
data class AlbumResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: Int
)