package com.TecsupStore

import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val contexto = LocalContext.current

    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val entradaActual by navController.currentBackStackEntryAsState()
    val rutaActual = entradaActual?.destination?.route

    ModalNavigationDrawer(
        drawerState = estadoDrawer,
        drawerContent = {
            AppDrawer(
                rutaActual = rutaActual,
                onDestinoClick = { ruta ->
                    navController.navigate(ruta) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                    scope.launch { estadoDrawer.close() }
                },
                onCerrarSesion = {
                    scope.launch { estadoDrawer.close() }
                    Toast.makeText(contexto, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text("TECSUP Store", fontWeight = FontWeight.Bold)
                            Text("Más vendidos", fontSize = 12.sp)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { estadoDrawer.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Abrir menú")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MoradoTecsup,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            }
        ) { espacioInterno ->
            NavHost(
                navController = navController,
                startDestination = "inicio",
                modifier = Modifier.padding(espacioInterno)
            ) {
                composable("inicio") { PantallaInicio() }
                composable("pedidos") { PantallaSimple("Mis pedidos") }
                composable("favoritos") { PantallaSimple("Favoritos") }
                composable("perfil") { PantallaSimple("Perfil") }
            }
        }
    }
}