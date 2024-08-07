package com.example.laboratorio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio1.ui.theme.Laboratorio1Theme

data class Item(val name: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio1Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val items = listOf(
        Item("Item 1"),
        Item("Item 2"),
        Item("Item 3")
    )
    var selectedItem = remember { mutableStateOf<Item?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        if (selectedItem.value == null) {
            Text("Select an item from the list")
        } else {
            Text("Selected: ${selectedItem.value?.name}")
        }
    }
}