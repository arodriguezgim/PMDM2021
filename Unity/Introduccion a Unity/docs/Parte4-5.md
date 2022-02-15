# 4.5. Incorporación de efectos de sonido

El sonido es una parte fundamental en la gran mayoría de juegos. Muchos
jugadores recuerdan perfectamente tanto la música de fondo como los
efectos sonoros de sus juegos favoritos. Por lo tanto, es un aspecto que
no debemos olvidar durante el desarrollo. Unity nos ofrece una gran
cantidad de herramientas para poder dotar a nuestro proyecto de un
sonido de calidad. Vamos a dar un pequeño repaso de cuáles son estas
herramientas antes de añadir el sonido a nuestro proyecto.

> Todos los _assets_ de sonido que importemos a nuestro proyecto
> (ficheros .mp3, .ogg, entre otros) se convierten en **Audio Clips**
> (clips de audio). De esta manera, abstraemos el tipo de fichero y su
> compresión, y trabajamos con el sonido de una manera unificada.

El elemento básico para generar sonidos es el componente AudioSource,
con el que podemos hacer sonar un _Audio Clip_ asignado a la propiedad
correspondiente. El origen del sonido estará allí donde esté situado el
GameObject con dicho componente. En este tipo de componente, por
defecto, la opción Play On Awake de los AudioSource está activada.
Esto provoca que el sonido se ponga en marcha en el momento en que se
crea el objeto, lo que puede ser adecuado para música de fondo, pero no
para efectos de sonido en momento puntuales (conviene desactivarla). La
opción más importante es el Audio Clip que le asignamos para que se
escuche, y también si queremos que se repita automáticamente, lo que se
consigue mediante la opción Loop.

> Añadiremos un AudioSource como componente a los objetos que generan
> sonidos.

Otro aspecto que hay que tener en cuenta es el componente que indica a
Unity desde dónde queremos escuchar los sonidos: el AudioListener. En
este sentido, hay que tener en cuenta que Unity hace una simulación de
la propagación del sonido a través del espacio, de manera que lo que
esté más lejos sonará más flojo. De todos modos, este _component_ se
añade normalmente en el mismo GameObject en el que está la cámara, de
la misma manera que nuestros ojos y nuestras orejas están cerca los unos
de los otros. Una escena suele tener como máximo uno activado a la vez.

> El resto de propiedades de AudioSource y AudioListener lo podéis
> consultar en la documentación de Unity
> ([aquí](https://docs.unity3d.com/ScriptReference/AudioSource.html) y
> [aquí](https://docs.unity3d.com/Manual/class-AudioListener.html),
> respectivamente).

De cara a aplicar estos componentes en nuestro proyecto, primero será
necesario explorar nuestros recursos para obtener sonidos. Un buen punto
de partida es el Asset Store, buscando sonidos de ambiente gratuitos.

| **Reto 11**                                                                                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Añadid una música de fondo para cada una de las pantallas del juego. De cara a generar los sonidos, podéis ubicar su origen (AudioSource) en la propia cámara, junto con el AudioListener. |

--> <a href="Parte4-6.md">Página siguiente</a>

<br /><hr />
