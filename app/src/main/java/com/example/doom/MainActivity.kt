package com.example.doom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        DoomScreen()
      }
    }
  }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DoomScreen() {
  val context = LocalContext.current
  var showDialog by remember { mutableStateOf(false) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Doom App") },
        actions = {
          IconButton(onClick = { showDialog = true }) {
            Icon(Icons.Default.Info, contentDescription = "Info")
          }
        }
      )
    },
    floatingActionButton = {
      FloatingActionButton(onClick = {
        Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show()
      }) {
        Icon(Icons.Default.Add, contentDescription = "Add")
      }
    },
    bottomBar = {
      BottomAppBar {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
          IconButton(onClick = {
            Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
          }) {
            Icon(Icons.Default.Home, contentDescription = "Home")
          }
          IconButton(onClick = {
            Toast.makeText(context, "Favorites", Toast.LENGTH_SHORT).show()
          }) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorites")
          }
          IconButton(onClick = {
            Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
          }) {
            Icon(Icons.Default.Person, contentDescription = "Profile")
          }
        }
      }
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
      ) {
        Text(
          "Контент внутри карточки 💀",
          modifier = Modifier.padding(16.dp),
          style = MaterialTheme.typography.bodyLarge
        )
      }

      // Можно добавить ещё карточек
      Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /* обработка клика */ }
      ) {
        Text(
          "Ещё один элемент",
          modifier = Modifier.padding(16.dp)
        )
      }
    }
  }

  // Диалог с информацией
  if (showDialog) {
    AlertDialog(
      onDismissRequest = { showDialog = false },
      title = { Text("О приложении") },
      text = { Text("Простое приложение на Jetpack Compose") },
      confirmButton = {
        TextButton(onClick = { showDialog = false }) {
          Text("OK")
        }
      }
    )
  }
}