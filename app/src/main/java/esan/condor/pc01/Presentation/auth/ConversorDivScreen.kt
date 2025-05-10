package esan.condor.pc01.Presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ConversorDivScreen() {
    var montoText by remember { mutableStateOf("") }
    var tipoConversion by remember { mutableStateOf("USD a PEN") }
    var resultado by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val tasaCambio = 3.80

    Column(
        modifier  = Modifier.fillMaxSize().padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text("Conversor de Divisas", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = montoText,
            onValueChange = { montoText = it },
            label = { Text("Monto a convertir") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = error.isNotEmpty()
        )

        Text("Tipo de conversión:")
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoConversion == "USD a PEN",
                onClick = { tipoConversion = "USD a PEN" }
            )
            Text("USD a PEN")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoConversion == "PEN a USD",
                onClick = { tipoConversion = "PEN a USD" }
            )
            Text("PEN a USD")
        }

        Button(onClick = {
            val monto = montoText.toDoubleOrNull()
            if (monto == null || monto <= 0) {
                error = "Por favor, ingresa un monto válido y positivo."
                resultado = ""
            } else {
                error = ""
                val conversion = if (tipoConversion == "USD a PEN") {
                    monto * tasaCambio
                } else {
                    monto / tasaCambio
                }
                val simbolo = if (tipoConversion == "USD a PEN") "S/" else "$"
                resultado = "Resultado: $simbolo${"%.2f".format(conversion)}"
            }
        },modifier = Modifier.fillMaxWidth()) {
            Text("Convertir")
        }

        if (resultado.isNotEmpty()) {
            Text(resultado, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
