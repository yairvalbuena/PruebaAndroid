# Aplicacion de Android
Repositorio de aplicación de prueba para Valid Prueba Ingreso
## Descripcion de la aplicacion:
La aplicacion muestra dos listados de los TOP ARTISTAS y TOP CANCIONES desde la API otorgada por [last.fm](https://www.last.fm/).
## Descripcion Tecnica:
* La app se estructura con MVC
* La App utiliza la API desde (http://www.last.fm/api/) para obtener los listados de artistas y canciones.
* Para utilizar la API se establece una API_KEY, proporcionada con anteriodridad.
* Se utiliza retrofit para realizar los peticiones REST al servicio.
* Se puede Cambiar la cantidad de artistas que se pueden mostrar Cambio la variable Respectiva a LIMIT_ARTIST o LIMIT_TRACKS en el archivo Constants.java.
* Se realizaron pruebas unitarias sobre dispositivo movil.
* Se realizan pruebas con Expresso Test Archivo Ubicado en app/src/androidTest/java/yairvalbuena.android.aplicacion/Activities/ExpressotestFunction
* La aplicacion cuenta con un sistema de resgistro y autenticacion utilizando FIREBASE. 
* Se puede entrar a la aplicación por medio del registro de un usuario nuevo o con las siguientes credenciales de prueba:
  *Email: test@test.com pass:123456 
  *Email: test2@test.com pasa:124567
* Se creo una cuenta de gmail paa acceder a firebase es de acceso libre las credenciales las anexo al correo.
* Librerias de terceros Utilizada:Retrofit2, firebase, Picasso.
* Añado APK para prueba simples en movil.
