package com.example.myassignment5_compose.ui.albumDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myassignment5_compose.data.model.album.Albums
import com.example.myassignment5_compose.data.model.album.AlbumsItemModel

@Composable
fun AlbumDetailScreen(getAlbums: Albums)
{}

//) {
//    val viewModel = hiltViewModel<AlbumDetailViewModel>()
//    val albumItem: AlbumsItemModel by viewModel.albumDetail.collectAsState()
//
//    viewModel.getAlbum()
//    AlbumDetailContent(albumDetails = albumItem)
//
//
//}
//
//@Composable
//fun AlbumDetailContent(albumDetails: AlbumsItemModel) {
//
//}
