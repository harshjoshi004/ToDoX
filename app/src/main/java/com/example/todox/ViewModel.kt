package com.example.todox

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    private var _list = mutableListOf<Task>()
    private var _idCount = 0
    @SuppressLint("MutableCollectionMutableState")
    val list = mutableStateOf(_list)

    //Methods of this class:

    fun addTask(string:String){
        _idCount++
        val it = Task(id = _idCount,str = string, underEditing = false)
        list.value=(list.value + it).toMutableList()
    }
    fun delTask(it1:Task){
        list.value = (list.value.filterNot { it.id == it1.id }).toMutableList()
    }
    fun updateTask(it1:Task){
        list.value = (list.value.map {
            if(it.id == it1.id){
                it1
            }
            else{
                it
            }
        }).toMutableList()
    }
    fun makeEditable(it1:Task){
        list.value = (list.value.map {
            if(it.id == it1.id){
                it.copy(underEditing = true)
            }
            else{
                it
            }
        }).toMutableList()
    }
}