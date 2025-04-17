package com.example.taskup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskup.screens.CreateTaskScreen
import com.example.taskup.ui.theme.TaskUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskUpTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateTaskScreen(modifier = Modifier.padding(innerPadding).padding(horizontal = 12.dp))
                }
            }
        }
    }
}
