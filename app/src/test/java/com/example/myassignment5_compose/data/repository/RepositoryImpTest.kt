package com.example.myassignment5_compose.data.repository

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepositoryImpTest {

    private lateinit var repository: RepositoryImp

    private lateinit var fakeApiRequest: FakeApiRequest





    @Before
    fun setUp() {
        fakeApiRequest = FakeApiRequest()
        repository = RepositoryImp(fakeApiRequest)

        MockitoAnnotations.openMocks(this)
        repository = RepositoryImp(fakeApiRequest)
    }

    @Test
    fun testGetPost() = runBlocking {
        //data
        val expectedPosts = arrayListOf(
            PostsItemModel(
                id = 1, title = "title",
                body = "body", userId = 0
            ),
            PostsItemModel(
                id = 2, title = "widget",
                body = "bodyType", userId = 2
            )
        )
        val fakeApiRequest = mock(ApiRequest::class.java)
        // Create the repository object and call the function being tested
        val repository = RepositoryImp(fakeApiRequest)
        `when`(fakeApiRequest.getPost()).thenReturn(expectedPosts)

        //when
        val actualPosts = repository.getPost()

        //then
        assertEquals(expectedPosts, actualPosts)
    }



    @Test
    fun `getComment should return a list of comments`() = runBlocking {
        // Create a test comment
        val testComment = CommentsItemModel("1", "1", 1, "email", 2)

        // Create a fake API request object and mock its getComment function
        val fakeApiRequest = mock(ApiRequest::class.java)
        `when`(fakeApiRequest.getComment()).thenReturn(arrayListOf(testComment))

        // Create a repository object with the fake API request object
        val repository = RepositoryImp(fakeApiRequest)

        // Call the getComment function and store the result in actualComment
        val actualComment = repository.getComment()

        // Verify that actualComment contains the expected comment
        assertEquals(arrayListOf(testComment), actualComment)
    }

    @Test
    fun `getAlbum should return list of albums`() = runBlocking {
        val album1 = AlbumsItemModel(1,"album1",1)
        val album2 = AlbumsItemModel(2,"album2",2)
        val albums = arrayListOf(album1, album2)

        // Set up the fake API request object
        val fakeApiRequest = mock(ApiRequest::class.java)
        // Create the repository object and call the function being tested
        val repository = RepositoryImp(fakeApiRequest)
        `when`(fakeApiRequest.getAlbum()).thenReturn(albums)
        val result = repository.getAlbum()
        assertEquals(albums,result)
    }

    @Test
    fun `getPhoto should return list of photos`() = runBlocking {
        val photo1 = PhotosItemModel(1, 1, "title1", "url1", "thumbnailUrl1")
        val photo2 = PhotosItemModel(2, 2, "title2", "url2", "thumbnailUrl2")
        val photos = arrayListOf(photo1, photo2)
        // Set up the fake API request object
        val fakeApiRequest = mock(ApiRequest::class.java)
        // Create the repository object and call the function being tested
        val repository = RepositoryImp(fakeApiRequest)

        `when`(fakeApiRequest.getPhoto()).thenReturn(photos)

        val result = repository.getPhoto()

        assertEquals(photos, result)
    }


    @Test
    fun `getTodo should return list of todos`() = runBlocking {
        val todo1 = TodosItemModel(true, 1, "title1", 1)
        val todo2 = TodosItemModel(false, 2, "title2", 2)
        val todos = arrayListOf(todo1, todo2)
        // Set up the fake API request object
        val fakeApiRequest = mock(ApiRequest::class.java)

        `when`(fakeApiRequest.getTodo()).thenReturn(todos)
        // Create the repository object and call the function being tested
        val repository = RepositoryImp(fakeApiRequest)
        val result = repository.getTodo()

        assertEquals(todos, result)
    }

    @Test
    fun `getUser should return list of users`() = runBlocking {
        val user1 = UsersItemModel("London", "name1", "username1", 2)
        val user2 = UsersItemModel("Watford", "name2", "username2", 1)
        val users = arrayListOf(user1, user2)

        // Set up the fake API request object
        val fakeApiRequest = mock(ApiRequest::class.java)
        `when`(fakeApiRequest.getUser()).thenReturn(users)

        // Create the repository object and call the function being tested
        val repository = RepositoryImp(fakeApiRequest)
        val result = repository.getUser()

        // Check that the result matches the expected data
        assertEquals(users, result)
    }



    @Test
    fun `getUserID should return the user with the specified ID`() = runBlocking {
        // Create a test user with ID 1

       val testUser = UsersItemModel("Luton","ITC","nazir@yahoo.com",1,"nazir","9893","dsdfsd","ewrer")

        val fakeApiRequest = mock(ApiRequest::class.java)





        // Mock the ApiRequest getUser function to return the test user
        `when`(fakeApiRequest.getUserID(1)).thenReturn(arrayListOf(testUser))

        // Call the getUserID method with the test user's ID
        val result = repository.getUserID(1)

        // Assert that the result matches the test user
        assertEquals(testUser, result)
    }





    @Test
    fun getApiRequest() {

    }
}