# Conversor de Monedas

Este proyecto fue desarrollado en Java y utiliza una API externa para obtener tasas de cambio en tiempo real, lo que permite realizar conversiones precisas y actualizadas. Es una herramienta poderosa para cualquier persona que necesite manejar diferentes monedas.

## Funcionalidades ✨

* **Conversiones Dinámicas:** Permite convertir entre cualquier par de monedas soportado por la API (la moneda base es USD).
* **Interfaz Amigable:** Un menú simple en la consola guía al usuario a través de las opciones de conversión y de consulta del historial.
* **Manejo de Errores:** Valida la entrada del usuario y maneja posibles errores de conexión con la API.

## Cómo Usar 🚀

Para correr este proyecto, necesitas tener instalado **Java 11 o superior** y la librería **Gson** para procesar el JSON de la API.

### 1. Obtener tu API Key

El proyecto usa la API de [ExchangeRate-API.com](https://www.exchangerate-api.com/).

* Ve a la página web de la API.
* Crea una cuenta gratuita.
* En tu panel de control, encontrarás tu **API Key**.
* Reemplaza el valor de `apiKey` en el archivo `ServicioDeConversion.java` con tu propia clave.
