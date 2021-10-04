package com.geo.album.viewmodel

import androidx.databinding.ObservableBoolean
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

    var loadingIndicator = ObservableBoolean(false)

    fun getAlbumList(): MutableLiveData<ArrayList<AlbumResult>> {
        loadingIndicator.set(true)
        val albumResult = MutableLiveData<ArrayList<AlbumResult>>()
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getAlbumList().collect { result ->
                loadingIndicator.set(false)
                albumResult.postValue(result)
            }
        }
        return albumResult
    }

    fun checkErrorState()= interactor.getErrorMessage()

}