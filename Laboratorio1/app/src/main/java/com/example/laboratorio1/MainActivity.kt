package com.example.laboratorio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
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
    var selectedItem by remember { mutableStateOf<Item?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        if (selectedItem == null) {
            ItemList(items) { item ->
                selectedItem = item
            }
        } else {
            Text("Selected: ${selectedItem?.name}")
            Button(onClick = { selectedItem = null }) {
                Text("Go Back")
            }
        }
    }
}

@Composable
fun ItemList(items: List<Item>, onItemClick: (Item) -> Unit) {
    LazyColumn {
        items(items) { item ->
            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onItemClick(item) }
            )
        }
    }
}
