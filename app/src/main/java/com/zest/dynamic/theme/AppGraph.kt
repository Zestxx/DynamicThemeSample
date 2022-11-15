package com.zest.dynamic.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zest.dynamic.theme.ui.screens.CardListScreen
import com.zest.dynamic.theme.ui.screens.ComponentsScreen
import com.zest.dynamic.theme.ui.screens.ImageListScreen
import com.zest.dynamic.theme.ui.screens.MainScreen

object AppGraph {
    private const val COLOR_ARG = "color"

    const val MAIN = "main"
    const val IMAGE_LIST = "image_list"
    const val CARD_LIST = "card_list"
    private const val COMPONENTS = "components/{$COLOR_ARG}"

    @Composable
    operator fun invoke(navController: NavHostController, paddingValues: PaddingValues) {
        NavHost(
            navController = navController,
            startDestination = MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(MAIN) {
                MainScreen(onScreenSelect = { navController.navigate(it) })
            }
            composable(IMAGE_LIST) {
                ImageListScreen()
            }

            composable(CARD_LIST) {
                CardListScreen(onCardSelect = { navController.navigate("components/$it") })
            }

            composable(
                route = COMPONENTS,
                arguments = listOf(navArgument(COLOR_ARG) { type = NavType.IntType })
            ) { navBackStackEntry ->
                navBackStackEntry.arguments
                    ?.getInt(COLOR_ARG)
                    ?.let { ComponentsScreen(color = it) }
            }
        }
    }
}
