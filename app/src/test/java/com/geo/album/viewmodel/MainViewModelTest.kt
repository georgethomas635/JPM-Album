package com.geo.album.viewmodel

import com.geo.album.domain.album.MainInteractor
import kotlinx.coroutines.runBlocking
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

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetAlbumList() {
        val viewModel = MainViewModel(interactor)

        runBlocking {
            viewModel.getAlbumList()
            Mockito.verify(interactor).getAlbumList()
        }
    }
}