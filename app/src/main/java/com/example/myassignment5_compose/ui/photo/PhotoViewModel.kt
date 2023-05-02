package com.example.myassignment5_compose.ui.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {



        private val _photoList= MutableStateFlow<ArrayList<PhotosItemModel>>(ArrayList())
        val photoList : StateFlow<ArrayList<PhotosItemModel>> = _photoList
        init {
            getPhoto()
        }

        fun getPhoto(){
            viewModelScope.launch{
                val response = repository.getPhoto()
                _photoList.value=response
            }
        }


    private val _albumList= MutableStateFlow<ArrayList<AlbumsItemModel>>(ArrayList())
    val albumlist : StateFlow<ArrayList<AlbumsItemModel>> = _albumList


    init {
        getAlbum()
    }
    fun getAlbum(){
        viewModelScope.launch {
            val response= repository.getAlbum()
            _albumList.getAndUpdate { response }
        }
    }
    }

