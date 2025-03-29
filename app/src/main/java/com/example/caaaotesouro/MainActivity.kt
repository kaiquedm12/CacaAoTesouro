package com.example.caaaotesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caaaotesouro.ui.theme.CaçaAoTesouroTheme

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
                    // Views Composables
                    Ask(
                        "Caça Ao Tesouro",
                        clickB1 = { meuNavController.navigate("/tela01") }

                    )
                }
                composable("/tela01") {
                    // Views Composables
                    pergunta1(
                        "Quem é o verdadeiro Rei Delas?",
                        clickB3 = { meuNavController.navigate("/home") },
                        clickB4 = { meuNavController.navigate("/tela02") }
                    )
                }
                composable("/tela02") {
                    // Views Composables
                    pergunta2(
                        "Quem é o maior jogador de futebol?",
                        clickB5 = { meuNavController.navigate("/tela03") },
                        clickB6 = { meuNavController.navigate("/tela01") }
                    )
                }
                composable("/tela03") {
                    // Views Composables
                    pergunta3(
                        "Qual numero eu estou pensando?",
                        clickB7 = { meuNavController.navigate("/tela02") },
                        clickB8 = { meuNavController.navigate("/tela04") }
                    )
                }
                composable("/tela04") {
                    // Views Composables
                    pergunta3(
                        "Qual numero eu estou pensando?",
                        clickB7 = { meuNavController.navigate("/home") },
                        clickB8 = { meuNavController.navigate("/tela01") }
                    )
                }
            }
        }
    }
}


@Composable
fun Tela(nomeTela: String,
         clickB1: () -> Unit,
         clickB2: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(nomeTela)
        Button(onClick = clickB1){Text("B1")}
        Button(onClick = clickB2){Text("B2")}
    }
}

@Preview
@Composable
fun Teste() {
    Tela(
        "Tela de teste",
        clickB1 = {},
        clickB2 = {}
    )
}