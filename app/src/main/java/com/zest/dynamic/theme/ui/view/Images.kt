package com.zest.dynamic.theme.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zest.dynamic.theme.R

@Composable
fun ImageList(onImageSelect: (Int) -> Unit) {
    val images = remember {
        listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4)
    }
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(images) { item ->
            AsyncImage(
                model = item,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clickable { onImageSelect(item) }
            )
        }
    }
}
