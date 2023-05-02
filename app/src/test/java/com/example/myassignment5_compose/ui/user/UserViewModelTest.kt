package com.example.myassignment5_compose.ui.user

import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiRequest
import com.example.myassignment5_compose.data.repository.FakeApiRequest
import com.example.myassignment5_compose.data.repository.RepositoryImp
import com.example.myassignment5_compose.ui.user.user_detail.UserDetailScreeen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class UserViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeRepository
    private  lateinit var viewModel: UserViewModel
    private lateinit var userDetailScreeen: UserDetailScreeen


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        fakeRepository = FakeRepository()
        viewModel = UserViewModel(fakeRepository)
        userDetailScreeen = UserDetailScreeen(fakeRepository)

        @Test
        fun getUsersList() = runBlocking {

        }
//            // Create a fake list of users
//            val users = listOf(
//                UsersItemModel("John Doe", "johndoe@gmail.com", "https://image.com/johndoe.png"),
//                UsersItemModel("Jane Doe", "janedoe@gmail.com", "https://image.com/janedoe.png")
//            )
//
//            // Create a mock ApiRequest instance
//            val fakeApiRequest = mock(ApiRequest::class.java)
//
//            // Mock the getUsers function to return the fake list of users
//            `when`(fakeApiRequest.getUser()).thenReturn(users)
//
//            // Create a UserViewModel instance with the mocked ApiRequest
//            val viewModel = UserViewModel(fakeApiRequest)
//
//            // Call the getUsersList function
//            val result = viewModel.getUserList()
//
//            // Assert that the result matches the fake list of users
//            assertEquals(users, result)
//        }

        @Test
        fun getUser() {
        }
    }}