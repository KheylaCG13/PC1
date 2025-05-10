package esan.condor.pc01.Presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

data class Producto(
    val nombre: String,
    val precio: Double,
    val categoria: String,
    val imagenUrl: String
)

@Composable
fun CatalogoProdScreen(navController: NavController) {
    val productos = listOf(
        Producto(
            nombre = "Laptop Dell XPS 13",
            precio = 4500.0,
            categoria = "Laptop",
            imagenUrl = "https://cdn.pixabay.com/photo/2015/01/21/14/14/apple-606761_1280.jpg"
        ),
        Producto(
            nombre = "iPhone 13 Pro",
            precio = 4200.0,
            categoria = "Smartphone",
            imagenUrl = "https://cdn.pixabay.com/photo/2022/05/10/19/37/iphone-7185196_1280.jpg"
        ),
        Producto(
            nombre = "Teclado Mecánico Corsair",
            precio = 250.0,
            categoria = "Accesorio",
            imagenUrl = "https://cdn.pixabay.com/photo/2014/05/02/21/50/keyboard-336392_1280.jpg"
        ),
        Producto(
            nombre = "Audífonos Sony WH-1000XM5",
            precio = 300.0,
            categoria = "Accesorio",
            imagenUrl = "https://cdn.pixabay.com/photo/2016/11/29/03/38/sony-1869583_1280.jpg"
        )
    )



    val total = productos.sumOf { it.precio }

    Column(modifier  = Modifier.fillMaxSize().padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text("Catálogo de Productos", style = MaterialTheme.typography.titleLarge)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(producto.imagenUrl),
                            contentDescription = producto.nombre,
                            modifier = Modifier.size(80.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(producto.nombre)
                            Text("Categoría: ${producto.categoria}")
                            Text("Precio: S/ ${"%.2f".format(producto.precio)}")
                        }
                    }
                }
            }
        }

        Text(
            text = "Total acumulado: S/ ${"%.2f".format(total)}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}
