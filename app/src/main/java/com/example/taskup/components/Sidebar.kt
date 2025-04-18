package com.example.taskup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SidebarDrawer(modifier: Modifier = Modifier, scope: CoroutineScope, navController: NavController,drawerState: DrawerState) {

    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.background
            )
            .padding(top = 50.dp)
            .requiredWidth(300.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        NavigationDrawerItem(
            shape = RoundedCornerShape(4.dp),
            label = {
                Text(text = "Início")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            },
            selected = false,
            onClick = {
                scope.launch {
                    drawerState.close()
                }
                navController.navigate("home")
            }
        )

        NavigationDrawerItem(
            shape = RoundedCornerShape(4.dp),
            label = {
                Text(text = "Nova tarefa")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            },
            selected = false,
            onClick = {
                scope.launch {
                    drawerState.close()
                }
                navController.navigate("create-task")
            }
        )
    }
}