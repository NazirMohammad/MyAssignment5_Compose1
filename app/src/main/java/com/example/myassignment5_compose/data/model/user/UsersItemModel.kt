package com.example.myassignment5_compose.data.model.user


import com.google.gson.annotations.SerializedName

data class UsersItemModel(
    @SerializedName("address")
    val address: String? = "",
    @SerializedName("company")
    val company: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("website")
    val website: String? = ""
)