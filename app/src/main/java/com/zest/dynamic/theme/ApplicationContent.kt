package com.zest.dynamic.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationContent() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()


    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Dynamic Theme demo") },
                    navigationIcon = {
                        if (backStackEntry?.destination?.route != AppGraph.MAIN) {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_arrow_back),
                                    contentDescription = "Back"
                                )
                            }
                        }
                    }
                )
            }
        ) { paddingValues ->
            AppGraph(navController, paddingValues)
        }
    }
}
