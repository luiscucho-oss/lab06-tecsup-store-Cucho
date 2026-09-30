package com.TecsupStore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DestinoDrawer(
    val ruta: String,
    val titulo: String,
    val icono: ImageVector
)

val destinosDrawer = listOf(
    DestinoDrawer("inicio", "Inicio", Icons.Default.Home),
    DestinoDrawer("pedidos", "Mis pedidos", Icons.Default.ShoppingCart),
    DestinoDrawer("favoritos", "Favoritos", Icons.Default.Favorite),
    DestinoDrawer("perfil", "Perfil", Icons.Default.Person)
)

@Composable
fun AppDrawer(
    rutaActual: String?,
    onDestinoClick: (String) -> Unit,
    onCerrarSesion: () -> Unit
) {
    val coloresItem = NavigationDrawerItemDefaults.colors(
        selectedContainerColor = LilaResaltado,
        selectedTextColor = MoradoTecsup,
        selectedIconColor = MoradoTecsup
    )

    ModalDrawerSheet {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(56.dp)
                    .clip(CircleShape)
                    .background(LilaResaltado),
                contentAlignment = Alignment.Center
            ) {
                Text("MR", fontWeight = FontWeight.Bold, color = MoradoTecsup, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Maria Rojas", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("maria@tecsup.edu.pe", fontSize = 13.sp, color = Color.Gray)
            }
        }

        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))

        destinosDrawer.forEach { destino ->
            NavigationDrawerItem(
                label = { Text(destino.titulo) },
                icon = { Icon(destino.icono, contentDescription = null) },
                selected = rutaActual == destino.ruta,
                onClick = { onDestinoClick(destino.ruta) },
                colors = coloresItem,
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }

        NavigationDrawerItem(
            label = { Text("Cerrar sesión") },
            icon = { Icon(Icons.Default.ExitToApp, contentDescription = null) },
            selected = false,
            onClick = onCerrarSesion,
            colors = coloresItem,
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}