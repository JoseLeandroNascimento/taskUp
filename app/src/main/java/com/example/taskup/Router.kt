package com.example.taskup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskup.screens.CreateTaskScreen
import com.example.taskup.screens.HomeScreen

@Composable
fun NavHostApp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("create-task") {
            CreateTaskScreen(navController = navController)
        }

    }

}