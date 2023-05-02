package com.example.myassignment5_compose.ui.user

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiDetails.posts
import com.example.myassignment5_compose.data.repository.Repository

class FakeRepository : Repository {


    override suspend fun getPost(): ArrayList<PostsItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getComment(): ArrayList<CommentsItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbum(): ArrayList<AlbumsItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoto(): ArrayList<PhotosItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getTodo(): ArrayList<TodosItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): ArrayList<UsersItemModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserID(id: Int): ArrayList<UsersItemModel> {
        TODO("Not yet implemented")
    }

}
