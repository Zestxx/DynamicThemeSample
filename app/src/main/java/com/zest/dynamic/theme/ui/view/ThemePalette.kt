package com.zest.dynamic.theme.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ThemePalette() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.padding(vertical = 8.dp), text = "PRIMARY")
        ColorsRow {
            ColorBox("primary", MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary)
            ColorBox("onPrimary", MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.primary)
            ColorBox(
                "primaryContainer",
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.colorScheme.onPrimaryContainer
            )
            ColorBox(
                "onPrimaryContainer",
                MaterialTheme.colorScheme.onPrimaryContainer,
                MaterialTheme.colorScheme.primaryContainer
            )
        }
        Text(modifier = Modifier.padding(vertical = 8.dp), text = "SECONDARY")
        ColorsRow {
            ColorBox("secondary", MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.onSecondary)
            ColorBox("onSecondary", MaterialTheme.colorScheme.onSecondary, MaterialTheme.colorScheme.secondary)
            ColorBox(
                "secondaryContainer",
                MaterialTheme.colorScheme.secondaryContainer,
                MaterialTheme.colorScheme.onSecondaryContainer
            )
            ColorBox(
                "onSecondaryContainer",
                MaterialTheme.colorScheme.onSecondaryContainer,
                MaterialTheme.colorScheme.secondaryContainer
            )
        }
        Text(modifier = Modifier.padding(vertical = 8.dp), text = "TERTIARY")
        ColorsRow {
            ColorBox("tertiary", MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.onTertiary)
            ColorBox("onTertiary", MaterialTheme.colorScheme.onTertiary, MaterialTheme.colorScheme.tertiary)
            ColorBox(
                "tertiaryContainer",
                MaterialTheme.colorScheme.tertiaryContainer,
                MaterialTheme.colorScheme.onTertiaryContainer
            )
            ColorBox(
                "onTertiaryContainer",
                MaterialTheme.colorScheme.onTertiaryContainer,
                MaterialTheme.colorScheme.tertiaryContainer
            )
        }
        Text(modifier = Modifier.padding(vertical = 8.dp), text = "NEUTRAL")
        ColorsRow {
            ColorBox("background", MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.onBackground)
            ColorBox("onBackground", MaterialTheme.colorScheme.onBackground, MaterialTheme.colorScheme.background)
            ColorBox(
                "surface",
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.onSurface
            )
            ColorBox(
                "onSurface",
                MaterialTheme.colorScheme.onSurface,
                MaterialTheme.colorScheme.surface
            )
        }
        Text(modifier = Modifier.padding(vertical = 8.dp), text = "NEUTRAL VARIANT")
        ColorsRow {
            ColorBox(
                "surfaceVariant",
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.colorScheme.onSurfaceVariant
            )
            ColorBox(
                "onSurfaceVariant",
                MaterialTheme.colorScheme.onSurfaceVariant,
                MaterialTheme.colorScheme.surfaceVariant
            )
            ColorBox(
                "outline",
                MaterialTheme.colorScheme.outline,
                MaterialTheme.colorScheme.outlineVariant
            )
            ColorBox(
                "outlineVariant",
                MaterialTheme.colorScheme.outlineVariant,
                MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
private fun ColorsRow(content: @Composable RowScope.() -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().height(60.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        content()
    }
}

@Composable
private fun RowScope.ColorBox(name: String, color: Color, textColor: Color) {
    Box(modifier = Modifier.fillMaxSize().background(color).weight(1F)) {
        Text(name, color = textColor)
    }
}
