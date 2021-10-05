package com.geo.album.viewmodel

import com.geo.album.domain.album.MainInteractor
import com.geo.album.domain.models.AlbumResult
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by George Thomas on 3/10/21
 */
class MainViewModelTest {

    @Mock
    lateinit var interactor: MainInteractor

    lateinit var viewModel:MainViewModel

    private val albumResultList = ArrayList<AlbumResult>()
    private lateinit var albumResult: AlbumResult

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        albumResult = AlbumResult(2, "consequatur autem doloribus natus consectetur")
        albumResultList.add(albumResult)

        viewModel = MainViewModel(interactor)

    }

    @Test
    fun testGetAlbumList() {
        val flow= flow{emit(albumResultList)}

        runBlocking {
            Mockito.`when`(interactor.getAlbumList()).thenReturn(flow)
            val result=viewModel.getAlbumList()
            Assert.assertNotNull(result)
        }
    }
}