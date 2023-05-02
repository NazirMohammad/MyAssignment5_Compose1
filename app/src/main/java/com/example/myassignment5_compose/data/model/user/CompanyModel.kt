package com.example.myassignment5_compose.data.model.user


import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("bs")
    val bs: String? = "",
    @SerializedName("catchPhrase")
    val catchPhrase: String? = "",
    @SerializedName("name")
    val name: String? = ""
)