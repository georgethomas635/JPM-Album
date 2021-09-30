package com.geo.album.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geo.album.domain.album.MainInteractor
import com.geo.album.domain.models.AlbumResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by George Thomas on 29/9/21
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: MainInteractor
) : ViewModel() {


    fun getAlbumList(): MutableLiveData<ArrayList<AlbumResult>> {
        val albumResult = MutableLiveData<ArrayList<AlbumResult>>()
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getAlbumList().collect { result ->
                albumResult.postValue(result)
            }
        }
        return albumResult
    }
}