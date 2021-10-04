package com.geo.album.service.db

import com.geo.album.domain.models.AlbumResult
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by George Thomas on 3/10/21
 */
class ConvertersTest {

    private lateinit var converter: Converters

    private val arrayList = ArrayList<String>()

    private val albumResponse = AlbumResult(
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
    fun testStringArrayListToJson() {
        val result = converter.stringArrayListToJson(arrayList)
        assertEquals(JSON_STRING, result)

    }

    @Test
    fun testFromJsonToStringArrayList() {
        val result = converter.fromJsonToStringArrayList(JSON_STRING)
        assertEquals(arrayList, result)
    }

    @Test
    fun testAlbumListToJson() {
        val result = converter.albumListToJson(albumList)
        assertEquals(Companion.ARRAY_CONVERTED, result)
    }

    @Test
    fun testFromJsonToAlbumList() {
        val result = converter.fromJsonToAlbumList(ARRAY_CONVERTED)
        assertEquals(albumList, result)
    }

    companion object {
        private const val JSON_STRING = "[\"TestOne\",\"TestTwo\"]"
        private const val ARRAY_CONVERTED =
            "[{\"id\":1,\"title\":\"consequatur autem doloribus natus consectetur\"}]"
    }

}