package com.example.myassignment5_compose.data.model.user


import com.google.gson.annotations.SerializedName

data class GeoModel(
    @SerializedName("lat")
    val lat: String? = "",
    @SerializedName("lng")
    val lng: String? = ""
)