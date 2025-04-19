package com.example.taskup.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    maxLines: Int = 1,
    minLines: Int = 1
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        maxLines = maxLines,
        minLines = minLines,
        label = {
            Text(text = label)
        }
    )
}