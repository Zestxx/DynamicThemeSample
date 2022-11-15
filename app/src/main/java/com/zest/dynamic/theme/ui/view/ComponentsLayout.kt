package com.zest.dynamic.theme.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zest.dynamic.theme.R

@Composable
fun ComponentsLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ComponentList(modifier = Modifier.weight(1F))
        BottomNavigationPanel()
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ComponentList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Button({}) {
                Text("Button")
            }
        }
        item {
            OutlinedButton({}) {
                Text("Outline button")
            }
        }
        item {
            TextField("TextField", {})

        }
        item {
            OutlinedTextField("OutlinedTextField", {})
        }

        item {
            FloatingActionButton({}) {
                Icon(painterResource(R.drawable.icon_edit), null)
            }
        }
        item {
            ExtendedFloatingActionButton({}) {
                Text("ExtendedFloatingActionButton")
            }
        }

        item {
            var isSwitchChecked by remember { mutableStateOf(false) }
            Switch(isSwitchChecked, { isSwitchChecked = it })
        }

        item {
            var isSelected by remember { mutableStateOf(false) }
            RadioButton(isSelected, { isSelected = !isSelected })
        }

        item {
            ThemePalette()
        }
    }
}

@Composable
private fun BottomNavigationPanel(modifier: Modifier = Modifier) {

    val items = mapOf(
        "Songs" to R.drawable.icon_library_music,
        "Artists" to R.drawable.icon_artists,
        "Playlists" to R.drawable.icon_playlist
    )
    var selectedItem by remember { mutableStateOf(R.drawable.icon_library_music) }

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 32.dp
    ) {
        items.forEach { (label, iconRes) ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = iconRes), contentDescription = label) },
                label = { Text(label) },
                selected = selectedItem == iconRes,
                onClick = { selectedItem = iconRes }
            )
        }
    }
}
