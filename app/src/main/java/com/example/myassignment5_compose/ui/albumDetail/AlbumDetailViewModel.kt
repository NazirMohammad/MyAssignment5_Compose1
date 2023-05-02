package com.example.myassignment5_compose.ui.albumDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    val repository: Repository
):ViewModel() {

    val albumDetail = MutableStateFlow<ArrayList<AlbumsItemModel>>(ArrayList())
    fun getAlbum() {
        viewModelScope.launch{
            val result = repository.getAlbum()
            albumDetail.value = result
        }
    }
}