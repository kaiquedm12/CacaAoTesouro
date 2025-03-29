package com.example.caaaotesouro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Ask(tituloAsk: String,
         clickB1: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(tituloAsk)
        Button(onClick = clickB1){ Text("Começar ao tesouro") }
    }
}

@Composable
fun pergunta1(
    Titulo1: String,
    clickB3: () -> Unit,
    clickB4: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(Titulo1)
        Button(onClick = clickB3){ Text("Lucas Cardoso Rodrigues") }
        Button(onClick = clickB4){ Text("Paulo de Souza Fontanela") }
    }
}