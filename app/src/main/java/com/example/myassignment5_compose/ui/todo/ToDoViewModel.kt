package com.example.myassignment5_compose.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
   private val repository: Repository
):ViewModel(){



    private val _todoList= MutableStateFlow<ArrayList<TodosItemModel>>(ArrayList())
    val todoList : StateFlow<ArrayList<TodosItemModel>> = _todoList
    init {
        getTodo()
    }

    fun getTodo(){
        viewModelScope.launch{
            val response = repository.getTodo()
            _todoList.value=response
        }
    }
}
