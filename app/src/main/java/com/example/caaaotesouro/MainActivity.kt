package com.example.caaaotesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val meuNavController = rememberNavController()
            NavHost(
                navController = meuNavController,
                startDestination = "/home"
            ) {
                composable("/home") {
                    Ask(
                        "Caça Ao Tesouro",
                        clickB1 = { meuNavController.navigate("/tela01") }
                    )
                }
                composable("/tela01") {
                    Pergunta(
                        titulo = "Quem é o verdadeiro Rei Delas?",
                        opcao1 = "Lucas Cardoso Rodrigues",
                        opcao2 = "Paulo de Souza Fontanela",
                        correta = 2,
                        onAcertou = { meuNavController.navigate("/tela02") },
                        onErrou = { meuNavController.navigate("/home") }
                    )
                }
                composable("/tela02") {
                    Pergunta(
                        titulo = "Quem é o maior jogador de futebol?",
                        opcao1 = "Caça Rato",
                        opcao2 = "Edson Arantes do Nascimento",
                        correta = 1,
                        onAcertou = { meuNavController.navigate("/tela03") },
                        onErrou = { meuNavController.navigate("/tela01") }
                    )
                }
                composable("/tela03") {
                    Pergunta(
                        titulo = "Qual número eu estou pensando?",
                        opcao1 = "3",
                        opcao2 = "18954",
                        correta = 2,
                        onAcertou = { meuNavController.navigate("/tela04") },
                        onErrou = { meuNavController.navigate("/tela02") }
                    )
                }
                composable("/tela04") {
                    TelaFinal(onReiniciar = { meuNavController.navigate("/home") })
                }
            }
        }
    }
}

@Composable
fun Ask(tituloAsk: String, clickB1: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(tituloAsk, color = Color.White)
        Button(onClick = clickB1, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Começar ao tesouro", color = Color.Black)
        }
    }
}

@Composable
fun Pergunta(titulo: String, opcao1: String, opcao2: String, correta: Int, onAcertou: () -> Unit, onErrou: () -> Unit) {
    var resultado by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titulo, color = Color.White)
        Button(onClick = {
            resultado = if (correta == 1) "Acertou!" else "Errou!"
            if (correta == 1) onAcertou() else onErrou()
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(opcao1, color = Color.Black)
        }
        Button(onClick = {
            resultado = if (correta == 2) "Acertou!" else "Errou!"
            if (correta == 2) onAcertou() else onErrou()
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(opcao2, color = Color.Black)
        }
        resultado?.let {
            Text(text = it, color = if (it == "Acertou!") Color.Green else Color.Red, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun TelaFinal(onReiniciar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "\uD83C\uDF89 Você achou o tesouro!", color = Color.White, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "\uD83C\uDFC6\uD83D\uDCB0", color = Color.Yellow, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onReiniciar, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Jogar Novamente", color = Color.Black)
        }
    }
}