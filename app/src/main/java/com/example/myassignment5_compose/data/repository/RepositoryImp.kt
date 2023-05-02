package com.example.myassignment5_compose.data.repository

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequest:ApiRequest
): Repository {
    override suspend fun getPost(): ArrayList<PostsItemModel> = apiRequest.getPost()



    override suspend fun getComment(): ArrayList<CommentsItemModel> =apiRequest.getComment()



    override suspend fun getAlbum(): ArrayList<AlbumsItemModel> =apiRequest.getAlbum()



    override suspend fun getPhoto(): ArrayList<PhotosItemModel> =apiRequest.getPhoto()



    override suspend fun getTodo(): ArrayList<TodosItemModel> = apiRequest.getTodo()



    override suspend fun getUser(): ArrayList<UsersItemModel> =apiRequest.getUser()
    override suspend fun getUserID(id: Int): ArrayList<UsersItemModel> = apiRequest.getUserID(id)

    }


