package com.example.myassignment5_compose.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _usersList= MutableStateFlow<ArrayList<UsersItemModel>>(ArrayList())
    val usersList : StateFlow<ArrayList<UsersItemModel>> = _usersList
    init {
        getUser()
    }

    fun getUser(){
        viewModelScope.launch{
            val response = repository.getUser()
            _usersList.value=response
        }
    }
}

