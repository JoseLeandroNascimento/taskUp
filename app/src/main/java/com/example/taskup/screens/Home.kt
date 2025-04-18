package com.example.taskup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskup.models.Task

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController? = null) {

    val tasks: List<Task> = listOf(
        Task(name = "Lavar o carro", description = "No sábado lavar o carro"),
        Task(name = "Fazer a tarefa de casa", description = "Tarefa de matemática"),
        Task(name = "Tarefa de geografia", description = "Estudar o mapa do Brasil"),
        Task(name = "Passear com o cachorro", description = "Levar o Bob no parque às 18h"),
        Task(name = "Organizar a mesa", description = "Limpar e organizar o espaço de estudos"),
        Task(name = "Estudar Kotlin", description = "Ler sobre coroutines e Compose"),
        Task(name = "Preparar o almoço", description = "Macarrão com molho branco"),
        Task(name = "Revisar o projeto", description = "Checar se tudo está funcionando no app"),
        Task(name = "Fazer backup do celular", description = "Subir fotos para o Google Drive"),
        Task(name = "Ler um capítulo do livro", description = "Livro de ficção científica")
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(count = tasks.size) {

            val taskCurrent = tasks[it]

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.surface  else Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp,
                ),

            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Row(
                       verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            Modifier
                                .padding(8.dp)
                                .size(40.dp)
                                .background(
                                    color = Color.Gray.copy(alpha = .2f),
                                    shape = RoundedCornerShape(100f)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                        }
                        Text(text = taskCurrent.name)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

    HomeScreen()
}