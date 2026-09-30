package com.TecsupStore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.TecsupStore.ui.theme.TecsupStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TecsupStoreTheme {
                Column(
                    modifier = Modifier.padding(16.dp).padding(top = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    productosEjemplo.forEach { TarjetaProducto(it) }
                }
            }
        }
    }
}