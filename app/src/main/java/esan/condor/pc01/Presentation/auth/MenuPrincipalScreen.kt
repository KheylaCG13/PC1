package esan.condor.pc01.Presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuPrincipalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text("Menu Principal", style = MaterialTheme.typography.titleLarge)

        //boton para acceder a la pantalla de calculadora de edad canina
        Button(
            onClick = {
                //navController.navigate("")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculadora Edad Canina")
        }

        //boton para acceder a la pantalla de conversor de divisas
        Button(
            onClick = {
                //navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Conversor de Divisas")
        }

        //boton para acceder a la pantalla de catalogo de productos
        Button(
            onClick = {
                //navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Catalogo de Productos")
        }
    }
}