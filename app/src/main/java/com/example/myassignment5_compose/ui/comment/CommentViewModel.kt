package com.example.myassignment5_compose.ui.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CommentViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {


        private val _commentList= MutableStateFlow<ArrayList<CommentsItemModel>>(ArrayList())
        val commentList : StateFlow<ArrayList<CommentsItemModel>> = _commentList
        init {
            getComment()
        }

        fun getComment(){
            viewModelScope.launch{
                val response = repository.getComment()
                _commentList.value=response
            }
        }
    }
