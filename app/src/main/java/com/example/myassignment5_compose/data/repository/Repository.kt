package com.example.myassignment5_compose.data.repository

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface Repository {

    suspend fun getPost():ArrayList<PostsItemModel>
    suspend fun getComment():ArrayList<CommentsItemModel>

    suspend fun getAlbum():ArrayList<AlbumsItemModel>

    suspend fun getPhoto():ArrayList<PhotosItemModel>

    suspend fun getTodo():ArrayList<TodosItemModel>

    suspend fun getUser():ArrayList<UsersItemModel>

    suspend fun getUserID(id :Int):ArrayList<UsersItemModel>

}