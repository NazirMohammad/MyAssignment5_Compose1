package com.example.myassignment5_compose.ui.comment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myassignment5_compose.data.model.comments.CommentsItemModel

@Composable
fun CommentScreen(viewModel: CommentViewModel= hiltViewModel(),navController: NavController
){
    val commentList by viewModel.commentList.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getComment()
    }


    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ){
        items(commentList) {comment->
            CommentItem(comment)
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}
@Composable
fun CommentItem(comment: CommentsItemModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "${comment.name}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${comment.body}",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${comment.email}",
                    color = Color.Black,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Post ID: ${comment.postId}",
                    color = Color.Black,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }}}


























//@Composable
//fun CommentItem(comment: CommentsItemModel) {
//    Row (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//
//            ){
//        Column(
//            modifier = Modifier
//                .padding(start = 16.dp)
//                .align(alignment = Alignment.CenterVertically)
//
//        ) {
//            Text(text = "${comment.name}",
//            color = Color.Black,
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "${comment.body}",
//                color = Color.Gray,
//                fontSize = 16.sp,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "${comment.email}",
//                color = Color.Black,
//                fontSize = 14.sp,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "${comment.postId}",
//                color = Color.Black,
//                fontSize = 14.sp,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//
//        }
//    }
//}
//


