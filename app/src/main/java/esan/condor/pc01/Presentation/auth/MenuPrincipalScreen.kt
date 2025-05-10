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
fun MenuPrincipalScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Menu Principal", style = MaterialTheme.typography.titleLarge)

        Button(
            onClick = {
                navController.navigate("calculadoraEdad")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculadora Edad Canina")
        }

        Button(
            onClick = {
                navController.navigate("conversor")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Conversor de Divisas")
        }

        Button(
            onClick = {
                navController.navigate("catalogo")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Catalogo de Productos")
        }
    }
}
