package com.example.myassignment5_compose.ui.todo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.repository.Repository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ToDoViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var  repository: Repository

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }
    @Test
    fun getTodoList()=  runTest {
        val todoItem = listOf(
            TodosItemModel(
                id =1,
                title = "title",
                userId = 0,
                completed = false,
            ),)
    }}

//            )
//
//val todo_sample = TodosItemModel(completed = false)
//
//        Mockito. `when`(repository.getTodo()).thenReturn(todoItem)
//        val viewModel = ToDoViewModel(repository)
//        viewModel.todoList
//

