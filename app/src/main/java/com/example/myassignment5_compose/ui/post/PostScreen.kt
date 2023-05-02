package com.example.myassignment5_compose.ui.post

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
import com.example.myassignment5_compose.data.model.post.PostsItemModel
import com.example.myassignment5_compose.navigationdrawer.NavigationItem


@Composable
fun PostScreen(navController: NavController) {
    val viewModel: PostViewModel = hiltViewModel()
    val postList by viewModel.postList.collectAsState()




    LaunchedEffect(Unit) {
        viewModel.getPost()


    }



    LazyColumn(
        modifier = Modifier

            .fillMaxSize()
            .padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        items(postList) { post ->
            PostItem(post, navController)

            Spacer(modifier = Modifier.height(16.dp))

        }

    }
}

@Composable
fun PostItem(
    post: PostsItemModel,
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
                    text = post.title ?: "Nazir",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = post.id.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = post.userId.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = post.body.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            IconButton(
                onClick = {}

            ) {
                Icon(

                    imageVector = Icons.Filled.ArrowForward,
                    modifier = Modifier.clickable {
                        navController.navigate(route = NavigationItem.Comment.route)

                    },
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}