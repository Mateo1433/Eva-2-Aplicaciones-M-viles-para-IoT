package com.example.riegointeligente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.riegointeligente.ui.theme.RiegoInteligenteTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RiegoInteligenteTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {

    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var mostrarPanel by remember { mutableStateOf(false) }

    if (mostrarPanel) {
        DashboardScreen()
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "🌱 Riego Inteligente",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Sistema de Riego IoT",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = {
                Text("Usuario")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = {
                Text("Contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {

                if (usuario == "admin" && contraseña == "1234") {
                    mostrarPanel = true
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("INGRESAR")
        }
    }
}

@Composable
fun DashboardScreen() {

    var riegoActivo by remember { mutableStateOf(false) }
    var mostrarHistorial by remember { mutableStateOf(false) }

    if (mostrarHistorial) {
        HistorialScreen(
            volver = {
                mostrarHistorial = false
            }
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "🌱 Riego Inteligente",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Panel de Control",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "💧 Humedad del suelo: 45%",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "🌡️ Temperatura: 24 °C",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "💦 Humedad ambiental: 60%",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (riegoActivo) {

            Text(
                text = "💧 Estado del riego: ACTIVO",
                style = MaterialTheme.typography.titleMedium
            )

        } else {

            Text(
                text = "⛔ Estado del riego: APAGADO",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                riegoActivo = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ACTIVAR RIEGO")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                riegoActivo = false
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DESACTIVAR RIEGO")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                mostrarHistorial = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("VER HISTORIAL")
        }
    }
}

@Composable
fun HistorialScreen(volver: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "📊 Historial",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "19:20  -  Humedad: 32%"
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "19:25  -  Humedad: 29%"
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "19:30  -  Riego activado"
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "19:35  -  Humedad: 41%"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                volver()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("VOLVER")
        }
    }
}
