package com.example.taskup.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController? = null) {
    Text(text = "Home")
}