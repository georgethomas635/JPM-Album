package com.geo.album.domain.album

import com.geo.album.domain.models.AlbumResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by George Thomas on 3/10/21
 */
@RunWith(MockitoJUnitRunner::class)
class MainInteractorImplTest {

    @Spy
    lateinit var interactor: MainInteractor

    @Mock
    lateinit var repository: MainRepository

    private val albumResultList = ArrayList<AlbumResult>()
    private lateinit var albumResult: AlbumResult

    @Before
    fun setup() {
        albumResult = AlbumResult(2, "consequatur autem doloribus natus consectetur")
        albumResultList.add(albumResult)
        interactor = MainInteractorImpl(repository)

    }

    @Test
    fun testGetAlbumList() {
        runBlocking {
            Mockito.lenient().`when`(repository.getAlbumList()).thenReturn(albumResultList)

            val result = interactor.getAlbumList()
            Assert.assertNotNull(result)
        }
    }

}