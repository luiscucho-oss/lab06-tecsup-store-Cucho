# Prompts usados con Gemini (rama mejora-ia)

Herramienta: Gemini integrado en Android Studio.
Objetivo: agregar un badge con contador en el ítem "Favoritos" del drawer, conectado con la opción "Favoritos" del DropdownMenu de cada producto.

## Prompt 1 — Estado de favoritos
**Prompt:**
Tengo una app en Jetpack Compose con TarjetaProducto.kt, Pantallas.kt, AppDrawer.kt y AppNavegacion.kt. Quiero guardar la lista de productos favoritos en AppNavegacion usando un estado (mutableStateListOf) y que TarjetaProducto reciba un callback onFavorito que agregue el producto a esa lista cuando el usuario toca "Favoritos" en el DropdownMenu. Pasa el callback a través de PantallaInicio. Usa nombres de variables en español.

**Resultado:**
Creó el estado productosFavoritos en AppNavegacion, agregó el parámetro onFavorito en TarjetaProducto y PantallaInicio, evitó duplicados, mostró un Toast de confirmación y creó PantallaFavoritos con la lista de productos marcados.

**Correcciones:**
Los mensajes del Toast usaban plantillas de texto (`"${producto.nombre} ..."`). Se cambiaron a concatenación (`producto.nombre + " ..."`) para mantener el mismo estilo del resto del proyecto.

## Prompt 2 — Badge en el drawer
**Prompt:**
En AppDrawer.kt agrega un parámetro cantidadFavoritos: Int y muestra un badge con ese número en el NavigationDrawerItem de "Favoritos" usando el parámetro badge. Solo debe mostrarse si la cantidad es mayor a 0. Pásale el tamaño de la lista de favoritos desde AppNavegacion.

**Resultado:**
Agregó cantidadFavoritos a AppDrawer y un Badge en el ítem "Favoritos" que solo aparece cuando hay al menos un favorito. Desde AppNavegacion se pasa productosFavoritos.size.

**Correcciones:**
Ninguna. El código compiló y funcionó a la primera; se verificó que el contador sube y baja correctamente.

## Prompt 3 — Quitar favoritos y evitar duplicados
**Prompt:**
Evita que un producto se agregue dos veces a favoritos. Si ya es favorito, que la opción del DropdownMenu diga "Quitar de favoritos" y lo quite de la lista. Muestra un Toast confirmando la acción.

**Resultado:**
Agregó el parámetro esFavorito en TarjetaProducto para cambiar el texto de la opción, y una función toggleFavorito en AppNavegacion que agrega o quita el producto y muestra el Toast correspondiente. La función se usa tanto en PantallaInicio como en PantallaFavoritos.

**Correcciones:**
Gemini cambió el texto de la opción pero mantuvo el ícono de corazón lleno también para "Quitar de favoritos". Se corrigió para mostrar el ícono FavoriteBorder (corazón vacío) cuando el producto ya es favorito, de modo que el ícono coincida con la acción.

## Observación
La lista de favoritos se guarda con `remember`, por lo que se pierde al rotar el dispositivo. Para conservarla se podría usar `rememberSaveable` o un ViewModel.