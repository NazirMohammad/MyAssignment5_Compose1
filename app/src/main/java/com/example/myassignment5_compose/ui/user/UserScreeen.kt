package com.example.myassignment5_compose.ui.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiDetails.user
import com.example.myassignment5_compose.navigationdrawer.NavigationItem

@Composable
fun UserScreeen(
    navController: NavController,

) {
   val viewModel: UserViewModel = hiltViewModel()
    val usersList by viewModel.usersList.collectAsState()
val navigateToDetails:(String)->Unit ={id ->
    navController.navigate("${NavigationItem.Users}/$id")
}


    LaunchedEffect(Unit) {
        viewModel.getUser()


    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        items(usersList) { user ->
            UserItem(user,navController)

            Spacer(modifier = Modifier.height(16.dp))

        }

    }
}

@Composable
fun UserItem(
    user: UsersItemModel,
    navController: NavController,

) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)

        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                {
                    // You can use an image here instead of a placeholder
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = user.name ?: "Nazir",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = user.email ?: "what is your email",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = user.address?.toString()?: "18 wyke close",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                }
                IconButton(
                    onClick ={}

                ) {
                    Icon(

                        imageVector = Icons.Filled.ArrowForward,
                        modifier = Modifier.clickable {
                            navController.navigate(route = NavigationItem.UserDetail.route)

                        },
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
    }