package com.geo.album.service.db

import com.geo.album.domain.models.AlbumResult
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by George Thomas on 3/10/21
 */
class ConvertersTest {

    private val ARRAY_CONVERTED =
        "[{\"id\":1,\"title\":\"consequatur autem doloribus natus consectetur\"}]"
    lateinit var converter: Converters

    private val arrayList = ArrayList<String>()
    private val JSON_STRING = "[\"TestOne\",\"TestTwo\"]"

    val albumResponse = AlbumResult(
        id = 1,
        title = "consequatur autem doloribus natus consectetur"
    )

    private val albumList = ArrayList<AlbumResult>()

    @Before
    fun setup() {
        arrayList.add("TestOne")
        arrayList.add("TestTwo")

        converter = Converters()

        albumList.add(albumResponse)
    }

    @Test
    fun testStringArraylistToJson() {
        val result = converter.stringArraylistToJson(arrayList)
        assertEquals(JSON_STRING, result)

    }

    @Test
    fun testFromJsonToStringArraylist() {
        val result = converter.fromJsonToStringArraylist(JSON_STRING)
        assertEquals(arrayList, result)
    }

    @Test
    fun testAlbumListToJson() {
        val result = converter.albumListToJson(albumList)
        assertEquals(ARRAY_CONVERTED, result)
    }

    @Test
    fun testFromJsonToAlbumList() {
        val result = converter.fromJsonToAlbumList(ARRAY_CONVERTED)
        assertEquals(albumList, result)
    }

}