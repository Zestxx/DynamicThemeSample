package com.zest.dynamic.theme.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zest.dynamic.theme.ui.DynamicTheme
import com.zest.dynamic.theme.ui.rememberDynamicThemeState
import com.zest.dynamic.theme.ui.view.ComponentsLayout

@Composable
fun ComponentsScreen(color: Int) {
    val themeState = rememberDynamicThemeState(Color(color))
    DynamicTheme(state = themeState) {
        // Компонент с демо элементами
        ComponentsLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        )
    }
}
