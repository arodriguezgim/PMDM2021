## 2.5. Carpetas especiales

Unity no trata a todos los _assets_ por igual, y la distinción la hace
según la carpeta en la que están ubicados. La razón es dar más
flexibilidad a los desarrolladores. Por ejemplo, podemos crear
funcionalidades que sirvan solo como herramientas para acelerar el
desarrollo dentro del editor, pero que no tengan sentido dentro del
juego. Este es un recurso muy típico al que se suele recurrir cuando los
juegos alcanzan un cierto nivel de complejidad. Pero no es el único. A
continuación, veremos algunas de las carpetas especiales de Unity más
relevantes y analizaremos su uso.

> Para obtener la información completa de todas las carpetas especiales,
> podemos acudir a la documentación oficial de Unity
> [aquí](https://docs.unity3d.com/Manual/SpecialFolders.html)

### 2.5.1. Carpeta Editor

Podemos generar fragmentos de código en forma de _scripts_ que nos
ayuden a acelerar nuestro progreso a la hora de desarrollar nuestro
juego, pero que no se incluirán en el juego una vez exportado a alguna
plataforma concreta. De este modo, optimizamos espacio y evitamos
posibles problemas.

### 2.5.2. Carpeta Plug-ins

Algunas funcionalidades se crean de manera específica para alguna
plataforma. Otras veces, simplemente queremos reaprovechar módulos ya
existentes programados en otros entornos y otros lenguajes. En estos
casos, normalmente, se generan archivos binarios ejecutables que se
puedan llamar directamente desde un _script_ de Unity. Para que Unity
los reconozca como _plug-ins_, hay que ponerlos en esta carpeta
especial.

> Algunos ejemplos de binarios ejecutables son los archivos .dll en
> Windows o .so en Android.

### 2.5.3. Carpeta Resources

Algunos _assets_ pueden ser costosos en términos de memoria y puede que
solo los necesitemos en algunos momentos en concreto. Para evitar esta
carga innecesaria, podemos usar ciertas funciones de código para indicar
qué _asset_ queremos instanciar. Eso sí, solo tendremos acceso vía
código a los _assets_ que se encuentren en la carpeta Resources.

### 2.5.4. Carpeta de recursos en línea

Muchas veces nos encontraremos que necesitamos recursos para nuestro
juego. Especialmente si somos un equipo pequeño, es muy complicado tener
nociones suficientes de cómo generar animaciones, texturas, música y
modelos 3D con suficiente calidad. Sin embargo, en muchas ocasiones, lo
que necesitamos ya ha sido creado para otro proyecto, y podemos
obtenerlo por un precio ajustado o, incluso, gratuitamente.

> La Asset Store es la tienda oficial de Unity. Contiene todo tipo de
> recursos, desde texturas y _scripts_ hasta animaciones o niveles
> completos de algún juego. Para descargar _assets_ desde la tienda es
> necesario tener una cuenta de Unity.

En esta tienda podemos encontrar recursos gratis y de pago, así como en
modalidad de prueba. Podemos acceder a la _Asset Store_ desde la web de
Unity o desde el propio editor, pero los _assets_ que queramos utilizar
solo los podemos descargar desde el editor.

Más allá de la tienda oficial, hay multitud de recursos _online_ que
podemos encontrar en diversas webs. Sin embargo, debemos ir siempre con
cuidado con los derechos de autor de todo aquello que nos planteemos
usar en nuestros proyectos.

--> <a href="Parte2-6.md">Página siguiente</a>

<br /><hr />
