package com.example.myassignment5_compose

import LoginViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myassignment5_compose.login.LoginScreen
import com.example.myassignment5_compose.navigationdrawer.NavigationItem
import com.example.myassignment5_compose.ui.album.AlbumScreen
import com.example.myassignment5_compose.ui.comment.CommentScreen
import com.example.myassignment5_compose.ui.photo.PhotoScreen
import com.example.myassignment5_compose.ui.post.PostScreen
import com.example.myassignment5_compose.ui.todo.ToDoScreen
import com.example.myassignment5_compose.ui.user.UserScreeen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
        }

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val targetScreen= rememberSaveable{ mutableStateOf(NavigationItem.Post) }
    //new login
    val loginViewModel= viewModel(modelClass = LoginViewModel::class.java)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, navController = navController, targetScreen.value) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController, loginViewModel = loginViewModel,targetScreen = targetScreen)


    }

}



@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController,targetScreen:NavigationItem){

    TopAppBar(
        title = { Text(text = targetScreen.title, fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,

    )

}





@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    val items = listOf(
        NavigationItem.Post,
        NavigationItem.Albums,
        NavigationItem.Comment,
        NavigationItem.Photos,
        NavigationItem.Todo,
        NavigationItem.Users,
        NavigationItem.Login
    )

    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)

                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ){

            Image(
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Yellow)



            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)


        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))




    }
}

@Composable
fun DrawerItem(item: NavigationItem,
               selected: Boolean,
               onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.purple_200
    else android.R.color.transparent

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier

            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .clip(CircleShape)


        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}





@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    targetScreen: MutableState<NavigationItem>,
){

    NavHost(
        navController,
        startDestination = NavigationItem.Login.route
    ) {
        composable(NavigationItem.Login.route){
            LoginScreen(navController  = navController, onNavToHomePage =
            {
                navController.navigate(NavigationItem.Post.route){
                    popUpTo(route=NavigationItem.Login.route){
                        inclusive= true
                    }
                }

            },



                onNavToSignUpPage = {navController.navigate(NavigationItem.Post.route)

            }
            )



        }


        composable(NavigationItem.Post.route)
        {
            targetScreen.value = NavigationItem.Post
            PostScreen(navController = navController)
        }

        composable(NavigationItem.Comment.route) {

            targetScreen.value = NavigationItem.Comment

           CommentScreen(navController = navController)
        }

        composable(NavigationItem.Albums.route)
        {
            targetScreen.value = NavigationItem.Albums

            AlbumScreen(navController = navController)
        }

        composable(NavigationItem.Photos.route)


        {

            targetScreen.value = NavigationItem.Photos

            PhotoScreen(navController = navController)
        }

        composable(NavigationItem.Todo.route) {

            targetScreen.value = NavigationItem.Todo

            ToDoScreen(navController = navController)
        }
        composable(NavigationItem.Users.route)
        {
            targetScreen.value = NavigationItem.Users

            UserScreeen(navController=navController)

        }
        composable(NavigationItem.UserDetail.route)
        {
            UserScreeen(navController = navController)
        }



//        composable("${NavigationItem.UserDetail.route}/{id}"){
//            targetScreen.value= NavigationItem.UserDetail
//            NavigationItem.UserDetail(it.arguments?.getString("id")!!, navController)
//        }

//            composable(NavigationItem.Login.route)
//            {
//                LoginScreen(navController=navController)


        }}

















