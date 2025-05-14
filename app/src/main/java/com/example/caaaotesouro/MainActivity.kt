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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import kotlin.system.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            var startTime by remember { mutableStateOf(0L) }
            var elapsedTime by remember { mutableStateOf(0L) }

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen {
                        startTime = System.currentTimeMillis()
                        navController.navigate("pista1")
                    }
                }

                composable("pista1") {
                    PistaScreen(
                        titulo = "O que é, o que é: cai em pé e corre deitado?",
                        respostaCorreta = "chuva",
                        onAcertou = { navController.navigate("pista2") },
                        onVoltar = { navController.popBackStack() }
                    )
                }

                composable("pista2") {
                    PistaScreen(
                        titulo = "Qual o animal que anda com uma pata só?",
                        respostaCorreta = "pato",
                        onAcertou = { navController.navigate("pista3") },
                        onVoltar = { navController.popBackStack() }
                    )
                }

                composable("pista3") {
                    PistaScreen(
                        titulo = "Qual é a capital do Brasil?",
                        respostaCorreta = "brasília",
                        onAcertou = {
                            elapsedTime = System.currentTimeMillis() - startTime
                            navController.navigate("tesouro/$elapsedTime")
                        },
                        onVoltar = { navController.popBackStack() }
                    )
                }

                composable(
                    "tesouro/{elapsedTime}",
                    arguments = listOf(navArgument("elapsedTime") { type = NavType.LongType })
                ) { backStackEntry ->
                    val time = backStackEntry.arguments?.getLong("elapsedTime") ?: 0L
                    TelaFinal(
                        tempo = time,
                        onReiniciar = { navController.navigate("home") { popUpTo("home") { inclusive = true } } }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onStartClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Caça Ao Tesouro", color = Color.White, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onStartClick, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Iniciar Caça ao Tesouro", color = Color.Black)
        }
    }
}

@Composable
fun PistaScreen(
    titulo: String,
    respostaCorreta: String,
    onAcertou: () -> Unit,
    onVoltar: () -> Unit
) {
    var resposta by remember { mutableStateOf(TextFieldValue("")) }
    var feedback by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titulo, color = Color.White, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = resposta,
            onValueChange = { resposta = it },
            label = { Text("Digite sua resposta") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (resposta.text.trim().lowercase() == respostaCorreta.lowercase()) {
                    feedback = "Resposta correta!"
                    onAcertou()
                } else {
                    feedback = "Resposta errada. Tente novamente."
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Próxima Pista", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onVoltar,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Voltar", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (feedback.isNotEmpty()) {
            Text(feedback, color = if (feedback.contains("correta")) Color.Green else Color.Red)
        }
    }
}

@Composable
fun TelaFinal(tempo: Long, onReiniciar: () -> Unit) {
    val segundos = tempo / 1000
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF6200EA)).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("\uD83C\uDF89 Parabéns! Você encontrou o tesouro!", color = Color.White, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("⏱ Tempo total: ${segundos}s", color = Color.Yellow, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onReiniciar, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Jogar Novamente", color = Color.Black)
        }
    }
}
