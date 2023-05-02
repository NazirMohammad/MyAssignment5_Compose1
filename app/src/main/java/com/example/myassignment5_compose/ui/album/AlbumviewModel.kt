package com.example.myassignment5_compose.ui.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumviewModel @Inject constructor(
    private val repository: Repository

): ViewModel() {

    private val _albumList= MutableStateFlow<ArrayList<AlbumsItemModel>>(ArrayList())
    val albumList : StateFlow<ArrayList<AlbumsItemModel>> = _albumList
    init {
        getAlbum()
    }

    fun getAlbum(){
        viewModelScope.launch{
            val response = repository.getAlbum()
            _albumList.value=response
        }
    }
}