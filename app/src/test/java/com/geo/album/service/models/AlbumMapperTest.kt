package com.geo.album.service.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by George Thomas on 3/10/21
 */
class AlbumMapperTest {

    private val mapper = AlbumMapper()
    private val response = ArrayList<AlbumResponse>()

    private val albumResponse = AlbumResponse(
        id = 1,
        userId = 90,
        title = "consequatur autem doloribus natus consectetur"
    )

    @Before
    fun setup() {
        response.add(albumResponse)
    }

    @Test
    fun testTransform() {
        val result = mapper.transform(response)
        Assert.assertNotNull(result)
    }
}