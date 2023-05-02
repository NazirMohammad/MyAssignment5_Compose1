package com.example.myassignment5_compose.data.model.album


import com.google.gson.annotations.SerializedName

data class AlbumsItemModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("userId")
    val userId: Int? = 0
)