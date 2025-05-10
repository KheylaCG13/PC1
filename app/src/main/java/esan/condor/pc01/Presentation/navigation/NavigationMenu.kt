package esan.condor.pc01.Presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import esan.condor.pc01.Presentation.auth.*

@Composable
fun NavigationMenu(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu"){
        composable("menu"){
            MenuPrincipalScreen()
        }
        composable("calculadoraEdad"){
            TODO()
        }

        //Navigation
        composable("conversor"){
            TODO()
        }

        composable("catalogo"){
            TODO()
        }
    }
}