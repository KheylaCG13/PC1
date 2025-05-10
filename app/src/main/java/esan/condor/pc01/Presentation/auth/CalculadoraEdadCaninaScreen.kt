package esan.condor.pc01.Presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraEdadCaninaScreen() {
    var edadText by remember { mutableStateOf("") }
    var tamanoText by remember { mutableStateOf("Pequeño") }
    var expanded by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val tamanos = listOf("Pequeño", "Mediano", "Grande")

    Column(
        modifier  = Modifier.fillMaxSize().padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text("Calculadora de edad canina", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = edadText,
            onValueChange = { edadText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Edad del perro (en años humanos)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text("Tamaño: $tamanoText")
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                tamanos.forEach { tamano ->
                    DropdownMenuItem(
                        text = { Text(tamano) },
                        onClick = {
                            tamanoText = tamano
                            expanded = false
                        }
                    )
                }
            }
        }

        Button(onClick = {
            val edad = edadText.toIntOrNull()
            if (edad == null || edad <= 0) {
                error = "Por favor, ingresa una edad válida y positiva."
                resultado = ""
            } else {
                error = ""
                val edadPerro = when (tamanoText) {
                    "Pequeño" -> edad * 5
                    "Mediano" -> edad * 6
                    else -> edad * 7
                }
                resultado = "¡Tu perro tiene $edadPerro años perrunos! Quien lo diria!!!"
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Calcular")
        }

        if (resultado.isNotEmpty()) {
            Text(resultado, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
