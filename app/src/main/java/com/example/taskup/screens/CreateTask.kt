package com.example.taskup.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskup.R
import com.example.taskup.components.InputText
import com.example.taskup.ui.theme.TaskUpTheme

@Composable
fun CreateTaskScreen(modifier: Modifier = Modifier, navController: NavController? = null) {

    val focusManager = LocalFocusManager.current
    val scroll = rememberScrollState(0)
    val context = LocalContext.current

    var nameTask by remember { mutableStateOf("") }
    var descriptionTask by remember { mutableStateOf("") }


    fun isValid(): Boolean {
        return nameTask.isNotEmpty() && descriptionTask.isNotEmpty()
    }

    fun saveHandle() {

        if (isValid()) {
            Toast.makeText(context, "Tarefa salva com sucesso!", Toast.LENGTH_LONG).show()
        }

    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .scrollable(state = scroll, orientation = Orientation.Vertical)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {

        InputText(
            modifier = Modifier.fillMaxWidth(),
            value = nameTask,
            onValueChange = { nameTask = it },
            label = stringResource(id = R.string.create_task_label_name)
        )

        InputText(
            modifier = Modifier.fillMaxWidth(),
            value = descriptionTask,
            maxLines = 3,
            minLines = 3,
            onValueChange = { descriptionTask = it },
            label = stringResource(id = R.string.create_task_label_description)
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { saveHandle() },
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = stringResource(id = R.string.create_task_btn_text_save))
        }

    }


}

@Preview
@Composable
private fun CreateTaskScreenPreview() {
    TaskUpTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CreateTaskScreen(
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp)
            )
        }
    }
}