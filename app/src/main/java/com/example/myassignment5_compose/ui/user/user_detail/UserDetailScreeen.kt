package com.example.myassignment5_compose.ui.user.user_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailScreeen @Inject constructor(
    val repository: Repository
): ViewModel() {


    val userDetailss = MutableStateFlow(UsersItemModel())


    fun getUserID(id: Int) {
        viewModelScope.launch {
            val result = repository.getUserID(id)[0]
            userDetailss.value = result
        }
    }
}