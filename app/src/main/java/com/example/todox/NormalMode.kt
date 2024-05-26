package com.example.todox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NormalView(task:Task,maModel: TaskViewModel){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(BorderStroke(4.dp,MaterialTheme.colorScheme.primary), RoundedCornerShape(20))
            .padding(8.dp)
    ) {
        //task String
        Text(text = task.str)

        //icons
        Row {
            //edit icon
            IconButton(onClick = { maModel.makeEditable(task) }) {
                Icon(Icons.Default.Edit, contentDescription = "")
            }

            //delete icon
            IconButton(onClick = { maModel.delTask(task) }) {
                Icon(Icons.Default.Delete, contentDescription = "")
            }
        }
    }
}
