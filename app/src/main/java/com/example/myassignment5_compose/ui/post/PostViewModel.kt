package com.example.myassignment5_compose.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: Repository
):ViewModel(){

    private val _postList = MutableStateFlow<ArrayList<PostsItemModel>>(ArrayList())
    val postList: StateFlow<ArrayList<PostsItemModel>> = _postList

    init {
        getPost()
    }

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            _postList.value=response
        }
    }
}
