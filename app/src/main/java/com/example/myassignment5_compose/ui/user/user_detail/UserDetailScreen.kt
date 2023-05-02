package com.example.myassignment5_compose.ui.user.user_detail

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import coil.compose.rememberAsyncImagePainter
import com.example.myassignment5_compose.data.model.user.UsersItemModel
import com.example.myassignment5_compose.data.remote.ApiDetails.user
import com.example.myassignment5_compose.navigationdrawer.NavigationItem
import com.example.myassignment5_compose.ui.user.UserItem

@Composable
fun UserDetailScreen(id: Int, user: UsersItemModel, navController: NavController,navHostController: NavHostController,viewmodel:UserDetailScreeen= hiltViewModel()) {

    val viewModel = hiltViewModel<UserDetailScreeen>()
    val userItem: UsersItemModel by viewModel.userDetailss.collectAsState()
    val navigateToUserDetailScreeen: (String) -> Unit = { id }
    navController.navigate(
        "${NavigationItem.UserDetail.route}/$id"

    )

    viewModel.getUserID(id)
    UserDetailContent(userDetailss= userItem)
//Column (modifier = Modifier.padding(top = 10.dp)
//){
//    LazyColumn(modifier = Modifier
//        .padding(top = 10.dp)
//    ){
//
//        items(id) {user->
//            if (user!=null){
//                user(userItem
//            }
//
//        }
//
//        }
//
//    }
}



@Composable
fun UserDetailContent(
    userDetailss: UsersItemModel,

) {
    Column() {
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .height(99.dp)
                        .background(color = Color(0xFFD1D1D1))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${userDetailss.username}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 10.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${userDetailss.phone}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 5.dp),
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = "${userDetailss.company}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 5.dp),
                        textAlign = TextAlign.End
                    )
                }
            }}}
}
