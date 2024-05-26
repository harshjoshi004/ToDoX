package com.example.todox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditView(task:Task, maModel:TaskViewModel){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(8.dp)
    )
    {
        var str1 by remember {
            mutableStateOf(task.str)
        }

        //text field for task
        BasicTextField(value = str1, onValueChange = {
            str1 = it
        })

        //save button
        IconButton(onClick = {
            val task2 = task.copy(str = str1, underEditing = false)
            maModel.updateTask(task2)
        }) {
            Icon(Icons.Default.CheckCircle, contentDescription = "")
        }
    }
}