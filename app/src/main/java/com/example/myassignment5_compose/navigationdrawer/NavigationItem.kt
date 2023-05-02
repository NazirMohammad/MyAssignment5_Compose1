package com.example.myassignment5_compose.navigationdrawer

import com.example.myassignment5_compose.R

sealed class NavigationItem(var route: String, var icon: Int, var title:String)
{
    object Post: NavigationItem("post", R.drawable.ic_post,"Post")
    object Comment: NavigationItem("comment", R.drawable.ic_comment,"Comment")
    object Albums: NavigationItem("albums", R.drawable.ic_album,"Albums")
    object Photos: NavigationItem("photos", R.drawable.ic_photo,"Photos")
    object Todo: NavigationItem("todo", R.drawable.ic_todo,"Todo")
    object Users : NavigationItem("users", R.drawable.ic_user,"Users")
    object UserDetail : NavigationItem("users_detail", R.drawable.ic_user,"Users_Detail")
    object Login : NavigationItem("login", R.drawable.ic_user,"Login")
    object Signup : NavigationItem("signup", R.drawable.ic_user,"SignUp")
    enum class loginRoutes{
        Signup,
        SignIn
    }




}