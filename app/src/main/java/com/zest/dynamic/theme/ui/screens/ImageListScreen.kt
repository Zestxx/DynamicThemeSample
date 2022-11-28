package com.zest.dynamic.theme.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zest.dynamic.theme.DynamicTheme
import com.zest.dynamic.theme.rememberDynamicThemeState
import com.zest.dynamic.theme.ui.view.ComponentsLayout
import com.zest.dynamic.theme.ui.view.ImageList
import kotlinx.coroutines.launch

@Composable
fun ImageListScreen() {
    val themeState = rememberDynamicThemeState()
    val coroutineScope = rememberCoroutineScope()
    DynamicTheme(themeState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
        ) {
            // Компонент со списком изображений из ресурсов
            ImageList(
                onImageSelect = { resId ->
                    coroutineScope.launch {
                        themeState.updateColorByImage(resId)
                    }
                }
            )
            // Компонент с демо элементами
            ComponentsLayout(Modifier.padding(top = 16.dp))
        }
    }
}
