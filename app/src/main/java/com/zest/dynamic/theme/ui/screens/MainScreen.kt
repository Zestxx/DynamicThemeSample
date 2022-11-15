package com.zest.dynamic.theme.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zest.dynamic.theme.AppGraph

@Composable
fun MainScreen(onScreenSelect: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable { onScreenSelect(AppGraph.CARD_LIST) },
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(
                    "Card list",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable { onScreenSelect(AppGraph.IMAGE_LIST) },
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(
                    "Image list",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
                )
            }
        }
    }
}
