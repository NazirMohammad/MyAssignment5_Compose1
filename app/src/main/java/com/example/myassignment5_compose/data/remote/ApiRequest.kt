package com.example.myassignment5_compose.data.remote

import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.model.comments.Comments
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.data.model.todo.TodosItemModel
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {

    @GET(ApiDetails.posts)
    suspend fun getPost():ArrayList<PostsItemModel>
    @GET(ApiDetails.comments)
    suspend fun getComment():ArrayList<CommentsItemModel>
    @GET(ApiDetails.albums)
    suspend fun getAlbum():ArrayList<AlbumsItemModel>
    @GET(ApiDetails.photos)
    suspend fun getPhoto():ArrayList<PhotosItemModel>
    @GET(ApiDetails.todos)
    suspend fun getTodo():ArrayList<TodosItemModel>
    @GET(ApiDetails.user)
    suspend fun getUser():ArrayList<UsersItemModel>
    @GET(ApiDetails.user)
    suspend fun getUserID(@Path("id")id :Int):ArrayList<UsersItemModel>



}


