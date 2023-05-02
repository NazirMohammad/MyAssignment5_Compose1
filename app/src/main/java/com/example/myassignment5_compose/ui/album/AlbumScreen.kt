package com.example.myassignment5_compose.ui.album

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
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel
import com.example.myassignment5_compose.data.remote.ApiDetails.albums

@Composable
fun AlbumScreen(
    viewModel:AlbumviewModel= hiltViewModel(),
){
    val albumList by viewModel.albumList.collectAsState()
//    val viewModel= hiltViewModel<AlbumviewModel>()
//    val albums by viewModel.albumList.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getAlbum()
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Album",
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)

) {

    items(albumList) { album ->

        AlbumItem(album)
        Spacer(modifier = Modifier.height(16.dp))
    }
}
    }

@Composable
fun AlbumItem(album: AlbumsItemModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${album.title}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Album ID: ${album.id}",
                color = Color.Gray,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "User ID: ${album.userId}",
                color = Color.Black,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
