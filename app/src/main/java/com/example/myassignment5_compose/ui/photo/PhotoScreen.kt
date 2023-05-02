package com.example.myassignment5_compose.ui.photo

import androidx.compose.foundation.Image
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
import coil.compose.rememberAsyncImagePainter
import com.example.myassignment5_compose.data.model.photos.PhotosItemModel

@Composable
fun PhotoScreen(navController: NavController,
    viewModel: PhotoViewModel = hiltViewModel(),
){
    val photoList by viewModel.photoList.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getAlbum()
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)

    ) {

        items(photoList) { photo ->

            photoItem(photo)
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}
@Composable
fun photoItem(photo: PhotosItemModel) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
    Text(text = "${photo.albumId}",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(bottom = 8.dp)
    )
                Text(text ="${photo.title}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = "${photo.url}",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)

                )

                Text(text ="${photo.thumbnailUrl}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp))

                Text(text ="${photo.albumId}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp))







//                Image(painter = rememberAsyncImagePainter(model = "${photo.thumbnailUrl}"),
//                    contentDescription = "null",
//                    modifier = Modifier
//                        .size(height = 90.dp, width = 60.dp)
//                        .weight(0.5f)
//                        .padding(5.dp)
//                )
//
//                Image(painter = rememberAsyncImagePainter(model = "${photo.url}"),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(height = 90.dp, width = 60.dp)
//                        .weight(0.5f)
//                        .padding(5.dp))

}}}
