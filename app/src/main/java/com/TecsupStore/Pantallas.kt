package com.TecsupStore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaInicio(onFavorito: (Producto) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productosEjemplo) { producto ->
            TarjetaProducto(
                producto = producto,
                onFavorito = onFavorito
            )
        }
    }
}

@Composable
fun PantallaFavoritos(
    productosFavoritos: List<Producto>,
    onFavorito: (Producto) -> Unit
) {
    if (productosFavoritos.isEmpty()) {
        PantallaSimple("No hay favoritos")
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productosFavoritos) { producto ->
                TarjetaProducto(
                    producto = producto,
                    onFavorito = onFavorito
                )
            }
        }
    }
}

@Composable
fun PantallaSimple(titulo: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = titulo, fontSize = 22.sp)
    }
}