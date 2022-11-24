package com.zest.dynamic.theme.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.palette.graphics.Palette
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import material.util.color.scheme.Scheme

@Composable
fun DynamicTheme(
    state: DynamicThemeState,
    content: @Composable () -> Unit,
) {
    val scheme = rememberColorScheme(state.primaryColor)
    MaterialTheme(
        colorScheme = scheme,
        content = content
    )
}

@Composable
fun rememberDynamicThemeState(
    initialPrimaryColor: Color = MaterialTheme.colorScheme.primary,
): DynamicThemeState {
    val context = LocalContext.current
    return remember { DynamicThemeState(initialPrimaryColor, context) }
}

@Composable
fun rememberDynamicThemeState(
    initialPrimaryColor: Int,
): DynamicThemeState {
    return rememberDynamicThemeState(Color(initialPrimaryColor))
}

@Stable
class DynamicThemeState(
    initialPrimaryColor: Color,
    private val context: Context,
) {

    var primaryColor: Color by mutableStateOf(initialPrimaryColor)

    var primaryColorArgb: Int
        set(value) {
            primaryColor = Color(value)
        }
        get() = primaryColor.toArgb()

    suspend fun updateColorByImage(@DrawableRes imageRes: Int) {
        withContext(Dispatchers.IO) {
            val bitmap = BitmapFactory.decodeResource(context.resources, imageRes)
            updateColorByImage(bitmap)
        }
    }

    suspend fun updateColorByImage(bitmap: Bitmap) {
        val palette = Palette.from(bitmap).generate()
        palette.dominantSwatch?.rgb?.let { primaryColor = Color(it) }
    }
}

@Composable
private fun rememberColorScheme(color: Color): ColorScheme {
    val isDarkTheme = isSystemInDarkTheme()
    val colorArgb = color.toArgb()
    return remember(color) {
        if (isDarkTheme) {
            Scheme.darkContent(colorArgb).toDarkThemeColorScheme()
        } else {
            Scheme.lightContent(colorArgb).toLightThemeColorScheme()
        }
    }
}

fun Scheme.toDarkThemeColorScheme(): ColorScheme {
    return darkColorScheme(
        primary = Color(primary),
        onPrimary = Color(onPrimary),
        primaryContainer = Color(primaryContainer),
        onPrimaryContainer = Color(onPrimaryContainer),
        inversePrimary = Color(inversePrimary),
        secondary = Color(secondary),
        onSecondary = Color(onSecondary),
        secondaryContainer = Color(secondaryContainer),
        onSecondaryContainer = Color(onSecondaryContainer),
        tertiary = Color(tertiary),
        onTertiary = Color(onTertiary),
        tertiaryContainer = Color(tertiaryContainer),
        onTertiaryContainer = Color(onTertiaryContainer),
        background = Color(background),
        onBackground = Color(onBackground),
        surface = Color(surface),
        onSurface = Color(onSurface),
        surfaceVariant = Color(surfaceVariant),
        onSurfaceVariant = Color(onSurfaceVariant),
        surfaceTint = Color(surfaceVariant),
        inverseSurface = Color(inverseSurface),
        inverseOnSurface = Color(inverseOnSurface),
        error = Color(error),
        onError = Color(onError),
        errorContainer = Color(errorContainer),
        onErrorContainer = Color(onErrorContainer),
        outline = Color(outline),
        outlineVariant = Color(outlineVariant),
        scrim = Color(scrim),
    )
}

fun Scheme.toLightThemeColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = Color(primary),
        onPrimary = Color(onPrimary),
        primaryContainer = Color(primaryContainer),
        onPrimaryContainer = Color(onPrimaryContainer),
        inversePrimary = Color(inversePrimary),
        secondary = Color(secondary),
        onSecondary = Color(onSecondary),
        secondaryContainer = Color(secondaryContainer),
        onSecondaryContainer = Color(onSecondaryContainer),
        tertiary = Color(tertiary),
        onTertiary = Color(onTertiary),
        tertiaryContainer = Color(tertiaryContainer),
        onTertiaryContainer = Color(onTertiaryContainer),
        background = Color(background),
        onBackground = Color(onBackground),
        surface = Color(surface),
        onSurface = Color(onSurface),
        surfaceVariant = Color(surfaceVariant),
        onSurfaceVariant = Color(onSurfaceVariant),
        surfaceTint = Color(surfaceVariant),
        inverseSurface = Color(inverseSurface),
        inverseOnSurface = Color(inverseOnSurface),
        error = Color(error),
        onError = Color(onError),
        errorContainer = Color(errorContainer),
        onErrorContainer = Color(onErrorContainer),
        outline = Color(outline),
        outlineVariant = Color(outlineVariant),
        scrim = Color(scrim),
    )
}
