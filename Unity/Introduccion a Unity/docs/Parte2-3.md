## 2.3. El editor de Unity

La gran mayoría de los motores de los juegos modernos proporcionan un
editor con el que podemos trabajar visualmente. Unity no es una
excepción, y su potente editor es posiblemente una de las claves detrás
de su éxito.

Por defecto, el editor de Unity se visualiza de la siguiente manera
cuando creamos un nuevo proyecto:

![](images/part2/editor.png)

El editor está compuesto por **_tabs_** (**pestañas**), cada una de las
cuales tiene una función específica. Las pestañas se pueden reordenar
--pulsando el botón izquierdo del ratón sobre las mismas y
arrastrándolas--, ajustar de tamaño o agrupar según nuestras
preferencias. Por defecto, las pestañas que aparecen son las de
Hierarchy, Scene, Game, Inspector, Project y Console, aunque existen
más, que cubriremos a medida que necesitemos opciones más avanzadas.

> La distribución de pestañas de Unity en un momento dado se conoce como
> el **_layout_**.

### 2.3.1. La pestaña Hierarchy

La pestaña Hierarchy contiene la lista de GameObjects de una escena.
Una escena se organiza en forma de jerarquía, de ahí el nombre de la
pestaña, de modo que los distintos GameObjects se pueden anidar unos
dentro de otros. Por ejemplo, en la imagen que se muestra a continuación
hemos añadido un cubo a la escena y luego hemos arrastrado con el ratón
el objeto llamado Main Camera al objeto llamado Cube:

![](images/part2/tab_hierarchy.png)

> Para añadir el cubo se ha usado la opción GameObject \> 3D Object \>
> Cube del menú principal de Unity. Esta opción también se puede
> acceder pulsando el botón derecho del ratón sobre la pestaña
> Hierarchy.

El resultado de emparentar dos objetos resulta en que los objetos hijo
se verán afectados siempre de la misma manera que su objeto padre. Así
pues, en el ejemplo, Main Camera (el GameObject hijo) se moverá,
rotará, se eliminará o se escalará siempre que Cube (el GameObject
padre) lo haga. Además de ser útil para sincronizar movimientos entre
objetos, este tipo de jerarquía también nos servirá para organizar
nuestra escena y encontrar nuestros objetos de una manera mucho más
rápida y cómoda.

> Una jerarquía no está limitada en número de hijos por padre ni en
> cuantos niveles de jerarquía hay por escena.

### 2.3.2. La pestaña Scene

La pestaña Scene es el editor visual de la escena con la que estamos
trabajando en Unity. Por ejemplo, después de añadir el cubo, el
resultado es el siguiente:

![](images/part2/tab_scene.png)

Cada uno de los objetos que hayamos añadido en la pestaña Hierarchy nos
aparecerá en la pestaña Scene representado por un símbolo. Además, el
objeto que tengamos seleccionado mostrará más detalles.

> El símbolo con el que se visualiza un objeto en la pestaña Scene se
> denomina **gizmo**. El símbolo utilizado varía según los componentes
> añadidos al GameObject correspondiente.

En la imagen que acabamos de ver, el objeto seleccionado es el Main
Camera, representado con una cámara porque tiene un componente Camera.
En la escena también hay una luz, que podemos ver por el gizmo de un
sol. Finalmente, en este ejemplo, al tener una cámara seleccionada en la
Hierarchy, podemos ver una previsualización (_preview_) de cómo se vería
la escena desde el punto de vista de la cámara en la parte inferior
derecha de la escena.

Existen varios modos de interactuar con los objetos y de navegar dentro
de esta pestaña. Estos modos se pueden cambiar con los botones que
tenemos justo debajo de la barra de menú o con las teclas.

![](images/part2/barra_interaccion.png)

> Podemos cambiar rápidamente de modo con las teclas QWERT del teclado.

> Podemos cambiar rápidamente de modo con las teclas QWERT del teclado.

Cada uno de los modos presenta una funcionalidad única:

- **Mano:** permite moverse alrededor de la escena.

- **Traslación:** permite trasladar (mover) el objeto seleccionado.

- **Rotación:** permite rotar el objeto seleccionado.

- **Escalado:** permite escalar (cambiar el tamaño) el objeto
  seleccionado.

- **Rectángulo:** permite cambiar el tamaño del objeto de UI
  seleccionado.

- **Traslación + Rotación + Escalado:** permite trasladar, rotar y
  escalar el objeto seleccionado.

- **Herramientas _custom_ del editor:** permite acceder a las
  herramientas _custom_ del editor (si las hay).

### 2.3.3. La pestaña Game

La pestaña Game se encuentra por defecto detrás de la de Scene. Para
seleccionarla, debemos pulsar sobre la pestaña, de modo que la pantalla
del editor queda reemplazada por otra que nos muestra el resultado que
obtendríamos si ejecutásemos el proyecto. Es decir, es donde realmente
nos tenemos que fijar para comprobar que todo funciona como esperábamos.

![](images/part2/tab_game.png)

Hay una opción en su barra de menú, llamada Stats, que es especialmente
interesante. Cuando está activada, nos muestra información sobre el
rendimiento (_performance_) de nuestra aplicación. En particular, hay
que destacar el número de milisegundos que consume nuestro juego en la
CPU y en el hilo de renderizado. Cuanto menor sea este número, mayor
será el rendimiento del mismo.

![](images/part2/stats.png)

Es importante remarcar que utilizar esta opción solo nos va a dar una
aproximación general del rendimiento real de nuestro juego, puesto que
el propio editor de Unity supone una carga adicional. Si queremos la
mayor fidelidad posible en los resultados, será necesario analizar una
_build_ final.

### 2.3.4. La pestaña Inspector

Esta es probablemente la pestaña más importante del editor. Aquí podemos
ver qué contienen los GameObjects seleccionados en la Hierarchy. Veamos
un ejemplo para el objeto llamado Main Camera.

![](images/part2/inspector_camera.png)

En este caso, podemos ver que Main Camera contiene componentes de tipo
Camera y Audio Listener. Además, tiene un componente de tipo Transform,
que contienen absolutamente todos los GameObjects.

> Dentro del componente Transform de un objeto se indica su posición,
> rotación y escala.

Recordemos que, en Unity, un GameObject es cualquier elemento del juego,
sin definir por sí mismo de qué se trata. Puede ser cualquier cosa: una
cámara, un elemento gráfico, un _script_, etc. Para que un objeto se
comporte de la manera deseada, debemos añadirle el componente adecuado.

> En Unity, los componentes de un objeto son los que realmente definen
> cuál es su comportamiento o cómo se va a representar en el juego.

Por ejemplo, si añadimos un componente vacío a nuestra escena, podemos
transformarlo en una luz pulsando en el botón Add Component que
encontramos en la pestaña Inspector y buscando el tipo Light entre la
lista de componentes.

![](images/part2/add_component.png)

> Para crear un objeto vacío se puede usar la opción Create \> Create
> Empty en la pestaña Hierarchy.
>
> Para encontrar rápidamente un componente en la lista, es recomendable
> usar el cuadro de búsqueda asociado.

Será solo de esta manera como el GameObject se comportará como una luz.
Añadiendo componentes adicionales, se pueden asociar diferentes
comportamientos a los GameObjects. Por ejemplo, el objeto de nuestro
ejemplo puede ser también una cámara si le añadimos el componente
adecuado.

Naturalmente, también podemos quitarle componentes a un objeto, pulsando
en la parte superior derecha (el icono con el engranaje) para activar el
siguiente menú:

![](images/part2/inspector_light1.png)

Una vez se ha añadido un componente, es posible configurar su
comportamiento en la misma pestaña Inspector:

![](images/part2/inspector_light2.png)

### 2.3.5. La pestaña Project

Esta pestaña muestra todos los ficheros que tenemos dentro de nuestro
proyecto.

> Se denomina **_asset_** a cualquier fichero importado que sea
> necesario para la ejecución del proyecto. Por ejemplo: imágenes,
> _scripts_ (fragmentos de código fuente), texturas, vídeos, modelos 3D,
> animaciones, etc.
>
> Podemos encontrar una gran cantidad de contenido libre y gratuito en
> webs como la siguiente: http://opengameart.org.

El aspecto inicial de la pestaña es el siguiente. En este caso, aún no
tenemos ningún archivo importado. Lo único que contiene el proyecto es
una escena de ejemplo que incluye automáticamente Unity.

![](images/part2/tab_project.png)

Supongamos que nos descargamos una imagen de Internet que deseamos
incorporar a nuestro proyecto. Para ello, podemos importarla de dos
maneras:

- Copiando el fichero en la carpeta Assets del proyecto de Unity en
  el sistema de ficheros de nuestro ordenador.

- Arrastrando el fichero directamente desde el explorador de archivos
  del ordenador al interior de la pestaña Project.

Una manera rápida de encontrar la carpeta Assets del ordenador es
haciendo clic derecho en la pestaña Project y seleccionando Show in
Explorer (o Reveal in Finder en Mac OS).

### 2.3.6. La pestaña Console

Esta pestaña nos mostrará todos los avisos y errores que ocurran en
nuestro proyecto. También permite mostrar mensajes de depuración
generados directamente desde el código de nuestro juego.

> Podemos encontrar más información sobre el uso de la pestaña Console [aquí](https://docs.unity3d.com/Manual/Console.html).

### 2.3.7. Modos de ejecución en Unity

Los dos modos de funcionamiento de Unity son:

- El **modo edición** (**_editor mode_**). Cuando estamos en este
  modo, el motor de juego está parado y tanto su código como muchas de
  sus herramientas integradas (como la física, sistemas de partículas,
  etc.) están detenidas. El modo edición sirve para que vayamos
  construyendo la escena sin tener distracciones, como objetos
  moviéndose o desapareciendo. En esencia, en este modo trabajamos con
  un editor de niveles.

- El **modo ejecución** (**_play mode_**). En este modo, en cambio,
  Unity está simulando que un usuario inicia la aplicación que hemos
  desarrollado. Todas las herramientas del motor se activarán y la
  experiencia que tengamos viendo la pestaña Game será muy similar a
  la que tendríamos al iniciar la aplicación real.

> En modo ejecución es posible modificar una escena del juego y sus
> elementos mediante el editor. Sin embargo, todo lo que se modifique en
> este modo se perderá una vez salgamos de él. Por ejemplo, si añadimos
> un objeto _A a la escena y borramos un objeto B existente, al volver
> al modo edición, el objeto A desaparecerá y el objeto B volverá a
> existir. En caso de querer mantener esas operaciones, hay que
> llevarlas a cabo siempre en el modo_ edición.

Para entrar en modo ejecución, simplemente hay que pulsar el botón Play
en el grupo de botones situado en la parte superior central del editor,
justo debajo del menú. Para salir, volvemos a pulsar Play, con lo que
volveremos a estar en modo edición. El botón de pausa congela la
aplicación momentáneamente; lo podemos usar para examinar con calma una
escena. El tercer botón sirve para ir _frame_ a _frame_, de modo que
podemos ver los cambios con mucho más detalle.

![](images/part2/botones_control.png)

--> <a href="Parte2-4.md">Página siguiente</a>

<br /><hr />
