package com.example.myassignment5_compose.data.repository

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiRequest

class FakeApiRequest : ApiRequest {

    private var mockedResponse: ArrayList<PostsItemModel>? = null

    private var mockedError: Boolean = false



    fun setMockedResponse(post: ArrayList<PostsItemModel>) {
        mockedResponse = post
        mockedError = false
    }


    override suspend fun getPost(): ArrayList<PostsItemModel> {
        return if (mockedError) {
            throw Exception("Error fetching beer list")
        } else ({
            mockedResponse ?: emptyList()
        }) as ArrayList<PostsItemModel>
    }



    override suspend fun getComment(): ArrayList<CommentsItemModel> {


        return if (mockedError) {
            throw Exception("error Feteching comments")
        } else ({
            mockedResponse ?: emptyList<CommentsItemModel>()
        }) as ArrayList<CommentsItemModel>

    }


    override suspend fun getAlbum(): ArrayList<AlbumsItemModel> {

        val album1 = AlbumsItemModel(1, "album1", 1)
        val album2 = AlbumsItemModel(2, "album2", 2)
        return arrayListOf(album1, album2)
    }



    override suspend fun getPhoto(): ArrayList<PhotosItemModel> {
        val photo1 = PhotosItemModel(1, 1, "title1", "url1", "thumbnailUrl1")
        val photo2 = PhotosItemModel(2, 2, "title2", "url2", "thumbnailUrl2")
        return arrayListOf(photo1, photo2)
    }

    override suspend fun getTodo(): ArrayList<TodosItemModel> {
        val todo1 = TodosItemModel(true, 1, "title1", 1)
        val todo2 = TodosItemModel(false, 2, "title2", 2)
        return arrayListOf(todo1, todo2)


    }
    override suspend fun getUser(): ArrayList<UsersItemModel> {

        val user1 = UsersItemModel("London", "name1", "username1", 2)
        val user2 = UsersItemModel("Watford", "name2", "username2", 2)
        return arrayListOf(user1, user2)

    }

    override suspend fun getUserID(id: Int): ArrayList<UsersItemModel> {
    return getUserID(id)
    }
}
//        val user1 = UsersItemModel("", "name1", "username1", 2)
//        val user2 = UsersItemModel("", "name2", "username2", 2)
//        return if (id == 1) user1 else user2



