package com.example.myassignment5_compose.navigationdrawer

import com.example.myassignment5_compose.R
import com.example.myassignment5_compose.data.model.user.Users

//sealed class NavigationItem(var route: String, var icon: Int, var title:String)
//{
//    object Post: NavigationItem("post", R.drawable.ic_post,"Post")
//    object Comment: NavigationItem("comment", R.drawable.ic_comment,"Comment")
//    object Albums: NavigationItem("albums", R.drawable.ic_album,"Albums")
//    object Photos: NavigationItem("photos", R.drawable.ic_photo,"Photos")
//    object Todo: NavigationItem("todo", R.drawable.ic_todo,"Todo")
//    object Users : NavigationItem("users", R.drawable.ic_user,"Users")
//    object UserDetail : NavigationItem("users_detail", R.drawable.ic_user,"Users_Detail")
//    object Login : NavigationItem("login", R.drawable.ic_user,"Login")
//    object Signup : NavigationItem("signup", R.drawable.ic_user,"SignUp")
//    enum class loginRoutes{
//        Signup,
//        SignIn
//    }
//
//
//
//
//}


enum class NavigationItem(var route: String, var icon: Int, var title:String, var maintab: Boolean =true){
    Post("post", R.drawable.ic_post,"Post"),
        Comment("comment", R.drawable.ic_comment,"Comment",false),
        Albums("albums", R.drawable.ic_album,"Albums",false),
        Photos("photos", R.drawable.ic_photo,"Photos",false),
        Todo("todo", R.drawable.ic_todo,"Todo",true),
        Users("users", R.drawable.ic_user,"Users",true),
        UserDetail("users_detail", R.drawable.ic_user,"Users_Detail",true),
        Login("login", R.drawable.ic_user,"Login",false),
        Signup("signup", R.drawable.ic_user,"SignUp",false),


}







