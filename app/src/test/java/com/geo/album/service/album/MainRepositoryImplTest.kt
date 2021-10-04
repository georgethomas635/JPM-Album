package com.geo.album.service.album

import com.geo.album.domain.album.MainRepository
import com.geo.album.domain.models.AlbumResult
import com.geo.album.service.db.AlbumDao
import com.geo.album.service.models.AlbumMapper
import com.geo.album.service.models.AlbumResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

/**
 * Created by George Thomas on 3/10/21
 */
@RunWith(MockitoJUnitRunner::class)
class MainRepositoryImplTest {

    @Spy
    lateinit var repository: MainRepository

    @Mock
    lateinit var albumService: AlbumService

    @Mock
    lateinit var albumDao: AlbumDao

    private val albumResponse = AlbumResponse(1, 12, "Sample Title")
    private val albumList = ArrayList<AlbumResponse>()
    private lateinit var albumResultList: ArrayList<AlbumResult>

    @Before
    fun setup() {
        albumList.add(albumResponse)
        albumResultList = AlbumMapper().transform(albumList)

        repository = MainRepositoryImpl(albumService, albumDao)
    }

    @Test
    fun testGetAlbumList() {

        runBlocking {
            Mockito.`when`(albumService.getAlbumList()).thenReturn(albumList)
            val response = repository.getAlbumList()
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun testGetAlbumListFromDB() {
        runBlocking {
            Mockito.`when`(albumDao.getAlbums()).thenReturn(albumResultList)
            val response = repository.getAlbumListFromDB()
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun testSaveAlbumListToDB() {
        runBlocking {
            repository.saveAlbumListToDB(albumResultList)
            verify(albumDao).insertAlbums(albumResultList)
        }
    }
}