package com.zest.dynamic.theme.ui.screens

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.zest.dynamic.theme.ui.DynamicTheme
import com.zest.dynamic.theme.ui.rememberDynamicThemeState
import com.zest.dynamic.theme.ui.view.ComponentsLayout
import com.zest.dynamic.theme.ui.view.ImageList

@Composable
fun ImageListScreen() {
    val context = LocalContext.current
    val themeState = rememberDynamicThemeState()
    DynamicTheme(themeState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
        ) {
            // Компонент со списком изображений из ресурсов
            ImageList(
                onImageSelect = { resId ->
                    // Извлекаем доминантный цвет из картинки
                    val domainColorRgb = exportDominantRgb(context, resId)
                    // Устанавливаем его как основной
                    domainColorRgb?.let { themeState.primaryColor = Color(it) }
                }
            )
            // Компонент с демо элементами
            ComponentsLayout(Modifier.padding(top = 16.dp))
        }
    }
}


fun exportDominantRgb(context: Context, imageRes: Int): Int? {
    val bitmap = BitmapFactory.decodeResource(context.resources, imageRes)
    val palette = Palette.from(bitmap).generate()
    return palette.dominantSwatch?.rgb
}
