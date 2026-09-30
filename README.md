# TECSUP Store — DropdownMenu y NavigationDrawer

**Curso:** Programación en Móviles — Tecsup
**Alumno:** Luis Cucho
**Profesor:** Juan José León Suiyón

## Descripción
Aplicación Android en Kotlin con Jetpack Compose que muestra una tienda con productos.
Cada tarjeta de producto tiene un menú contextual (DropdownMenu) y la app cuenta con
un menú lateral (NavigationDrawer) para navegar entre pantallas.

## Requisitos funcionales
- Cada tarjeta de producto tiene un ícono de 3 puntos (⋮) a la derecha.
- Al tocarlo se despliega un DropdownMenu con las opciones "Favoritos", "Compartir" y "Reportar".
- Cada opción del DropdownMenu tiene su ícono correspondiente (leadingIcon).
- Un ícono ≡ en la topBar abre un NavigationDrawer con los destinos Inicio, Mis pedidos, Favoritos, Perfil y Cerrar sesión.
- El encabezado del drawer muestra el avatar con iniciales y los datos básicos del usuario (nombre y correo).
- El destino activo del drawer se resalta visualmente con un color de fondo distinto al resto.

## Funcionalidades (rama main)
- Ícono de 3 puntos en cada tarjeta de producto que abre un DropdownMenu.
- DropdownMenu con opciones Favoritos, Compartir y Reportar, cada una con su ícono y divisores.
- La tarjeta se resalta con borde morado cuando su menú está abierto.
- Ícono ≡ en la topBar que abre el NavigationDrawer.
- Drawer con encabezado de usuario (iniciales, nombre y correo).
- Destinos: Inicio, Mis pedidos, Favoritos, Perfil y Cerrar sesión.
- Navegación real entre pantallas con Navigation Compose.
- El destino activo se resalta con color de fondo.

## Capturas

### Pantalla de inicio
<img width="293" height="636" alt="image" src="https://github.com/user-attachments/assets/b20f02bf-3486-4541-b4d7-5e0937f9b52d" />

### DropdownMenu abierto sobre un producto
<img width="293" height="637" alt="image" src="https://github.com/user-attachments/assets/3058d432-5d48-4ac4-9a24-47e1568d9904" />

### NavigationDrawer con navegación principal
<img width="293" height="635" alt="image" src="https://github.com/user-attachments/assets/9c5986b8-6bea-4457-94f0-741cff5912db" />

### Navegación a otra pantalla (ítem activo resaltado)

<img width="295" height="634" alt="image" src="https://github.com/user-attachments/assets/d3f407a3-8ade-46e1-a8e6-c156e5dacd7b" />


## Estructura de archivos
| Archivo | Contenido |
|---|---|
| `MainActivity.kt` | Punto de entrada, llama a AppNavegacion |
| `AppNavegacion.kt` | ModalNavigationDrawer, topBar y NavHost |
| `AppDrawer.kt` | Contenido del drawer (ModalDrawerSheet) |
| `TarjetaProducto.kt` | Tarjeta con ícono de 3 puntos y DropdownMenu |
| `Pantallas.kt` | Pantalla de inicio y pantallas simples |
| `Producto.kt` | Modelo de datos y lista de ejemplo |
| `Colores.kt` | Colores de la app |

## Ramas
- `main`: Fase 1, desarrollo base.
- `mejora-ia`: Fase 2, badge con contador de favoritos usando Gemini de Android Studio.

## Tecnologías
Kotlin, Jetpack Compose, Material 3, Navigation Compose.
