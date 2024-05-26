package com.example.todox

import android.media.tv.TvContract.Channels.Logo
import android.media.tv.TvContract.Channels.TYPE_1SEG
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

@Composable
fun MyPreview(maModel:TaskViewModel) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    Column {
        //actionbar
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier= Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            //add item logo
            IconButton(onClick = {
                showDialog = true
            }) {
                Icon(
                    Icons.Default.AddCircle,
                    contentDescription = "",
                    Modifier.padding(8.dp)
                )
            }

            //heading
            Text(text = "ToDoX - by Harsh Joshi    ",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
            )
        }

        //below actionbar
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            //then our lazyColumn
            LazyColumn(
                modifier=Modifier.padding(8.dp)
            ){
                items(maModel.list.value){
                    Spacer(modifier = Modifier.size(8.dp))
                    if(it.underEditing)
                        EditView(it,maModel)
                    else
                        NormalView(it,maModel)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        }
    }

    if(showDialog){
        var dialogStr by remember {
            mutableStateOf("")
        }
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                //Title of Alert Dialog
                Text(text = "Add Task")
            },
            text = {
                Column {
                    //Enter Task Name
                    OutlinedTextField(value = dialogStr, onValueChange = {
                        dialogStr = it
                    })
                }
            },
            confirmButton = {
                //save button
                Button(onClick = {
                    if(dialogStr.isNotBlank()){
                        maModel.addTask(dialogStr)
                    }
                    showDialog = false
                }) {
                    Icon(Icons.Default.CheckCircle, contentDescription = "")
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Save")
                }
            },

        )
    }
}


