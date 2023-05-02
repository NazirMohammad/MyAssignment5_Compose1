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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myassignment5_compose.login.LoginScreen
import com.example.myassignment5_compose.loginRepository.AuthRepository
import com.example.myassignment5_compose.navigationdrawer.NavigationItem
import com.example.myassignment5_compose.ui.album.AlbumScreen
import com.example.myassignment5_compose.ui.comment.CommentScreen
import com.example.myassignment5_compose.ui.photo.PhotoScreen
import com.example.myassignment5_compose.ui.post.PostScreen
import com.example.myassignment5_compose.ui.theme.MyAssignment5_ComposeTheme
import com.example.myassignment5_compose.ui.todo.ToDoScreen
import com.example.myassignment5_compose.ui.user.UserScreeen
import com.example.myassignment5_compose.ui.user.user_detail.UserDetailScreeen
import com.example.myassignment5_compose.ui.user.user_detail.UserDetailScreen
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
    //new login
    val loginViewModel= viewModel(modelClass = LoginViewModel::class.java)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, navController = navController) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController, loginViewModel = loginViewModel)


    }

}



@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    TopAppBar(
        title = { Text(text = "JSON Place Holder", fontSize = 18.sp) },
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
fun Navigation(navController: NavHostController = rememberNavController(),
loginViewModel: LoginViewModel,
){

    NavHost(
        navController,
        startDestination = NavigationItem.Login.route
    ) {
        composable(NavigationItem.Login.route){
            LoginScreen(navController  = navController, onNavToHomePage =
            {
                navController.navigate(NavigationItem.Post.route)

            }, onNavToSignUpPage = {navController.navigate(NavigationItem.Post.route)
            })



        }




        composable(NavigationItem.Post.route)
        {
            PostScreen(navController = navController)
        }

        composable(NavigationItem.Comment.route) {
           CommentScreen()
        }

        composable(NavigationItem.Albums.route) {
            AlbumScreen()
        }

        composable(NavigationItem.Photos.route) {
            PhotoScreen()
        }

        composable(NavigationItem.Todo.route) {
            ToDoScreen(navController = navController)
        }
        composable(NavigationItem.Users.route)
        {

            UserScreeen(navController=navController)

        }
        composable(NavigationItem.UserDetail.route)
        {
            UserScreeen(navController = navController)
        }
//            composable(NavigationItem.Login.route)
//            {
//                LoginScreen(navController=navController)



        }}

















