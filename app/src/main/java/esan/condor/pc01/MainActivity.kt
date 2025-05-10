package esan.condor.pc01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import esan.condor.pc01.Presentation.auth.CalculadoraEdadCaninaScreen
import esan.condor.pc01.Presentation.auth.CatalogoProdScreen
import esan.condor.pc01.Presentation.auth.ConversorDivScreen
import esan.condor.pc01.Presentation.auth.MenuPrincipalScreen
import esan.condor.pc01.ui.theme.PC1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PC1Theme {
                CatalogoProdScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PC1Theme {
        Greeting("Android")
    }
}