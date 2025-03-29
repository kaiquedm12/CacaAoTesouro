package com.example.caaaotesouro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun pergunta2(
    Titulo1: String,
    clickB5: () -> Unit,
    clickB6: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(Titulo1)
        Button(onClick = clickB5){ Text("Caça Rato") }
        Button(onClick = clickB6){ Text("Edson Arantes do Nascimento") }
    }
}

@Composable
fun pergunta3(
    Titulo1: String,
    clickB7: () -> Unit,
    clickB8: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(Titulo1)
        Button(onClick = clickB7){ Text("3") }
        Button(onClick = clickB8){ Text("18954") }
    }
}

@Composable
fun FinalScreen(
    onReiniciar: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🎉 Parabéns!",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Você encontrou o tesouro escondido! 🏆💰",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Tesouro",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button (onClick = onReiniciar) {
            Text("Jogar Novamente")
        }
    }
}