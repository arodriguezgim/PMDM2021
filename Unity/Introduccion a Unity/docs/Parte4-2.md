## 4.2. Creación de la interfaz de usuario básica

Una interfaz de usuario intuitiva e informativa es esencial para que el
usuario sepa cómo manejarse dentro del juego. Una gran mayoría de juegos
empiezan con un menú principal desde donde se pueden comenzar partidas
nuevas o continuar partidas existentes. Si bien hay juegos que han
explorado maneras más originales de cumplir esta función, esta es una
fórmula clásica y probada que sabemos que no va a fallar. Empezaremos,
pues, por esta pantalla.

En primer lugar, crearemos un nuevo proyecto de Unity, recordando
seleccionar el _template_ 2D. Una vez creado el proyecto,
seleccionaremos la pestaña Game y la ubicaremos, arrastrándola, a la
derecha de la pestaña Scene, para trabajar más cómodamente. A
continuación, añadiremos un botón mediante la opción de menú GameObject
\> UI \> Button.

> En el menú GameObject se agrupan distintos tipos de objetos. Entre
> ellos, UI para los de interfaz de usuario.

El resultado debería ser muy parecido a la siguiente figura, que será
nuestro punto de partida:

![](images/part4/button.png)

### 4.2.1. Elementos de UI en Unity

Al añadir el botón, se han creado varios GameObjects en el apartado de
Hierarchy. Uno de ellos lleva por nombre EventSystem. Si lo
seleccionamos, veremos en el Inspector que contiene dos componentes: un
Event System y un Standalone Input Module.

Por una parte, el componente Event System permite recibir la interacción
del usuario, y simplemente necesitamos que exista uno en la escena para
poder llevar a cabo esta función. Por otra parte, el componente
Standalone Input Module se encarga de hacer la traducción de las
acciones a eventos. Por ejemplo, en este componente podemos seleccionar
cuál es el botón de cancelar una acción o cómo se llaman los ejes
verticales y horizontales. En general, si no estamos experimentando con
controles específicos para nuestra aplicación, los valores por defecto
serán adecuados para la mayoría de las situaciones habituales.

Otro GameObject que se ha creado en la Hierarchy es el llamado Canvas.
Si lo seleccionamos y observamos en el Inspector, lo primero que nos
llamará la atención es que no tiene un componente Transform, sino uno
llamado Rect Transform. En realidad, se trata de un caso específico de
Transform que usan los elementos de UI en Unity. Internamente funciona
igual que un Transform, pero nos proporciona una manera más cómoda de
interacción para el diseño de nuestra UI. Los siguientes tres
_components_ en este GameObject son Canvas, Canvas Scaler y Graphic
Raycaster. El funcionamiento exacto de estos tres _components_ es
complejo, pero se puede resumir diciendo que nos permiten definir un
área donde podemos añadir elementos de UI, y que se encargan de calcular
a qué elementos afecta la interacción del usuario. Por ahora, esto es
suficiente.

> Todos los elementos de UI han de ser nodos hijo del _Canvas_.

Finalmente, está el propio botón, el objeto Button, que ha aparecido
como elemento hijo de Canvas. A su vez, ha aparecido un objeto Text como
hijo de Button. Los nombres son bastante autoexplicativos.

> Este GameObject representa un texto en una UI. Como hijo de un botón,
> representa el texto que contiene.

Si observamos Button en el Inspector, vemos que tiene tres componentes:
Canvas Renderer, Image y Button. Canvas Renderer es el componente que le
indica a Unity que hay elementos visuales de una UI (por ejemplo, texto,
una imagen, etc.) y, por lo tanto, hay que añadirlo para que se vean por
pantalla. Image permite especificar la imagen que se mostrará en nuestra
UI, mientras que Button es únicamente una manera de indicarle a Unity
que este GameObject tiene una interacción de botón, pero no se encarga
de mostrar nada por pantalla.

> Cualquier GameObject con un componente Button se comporta como un
> botón, respondiendo a la entrada del usuario.

Así pues, como vemos, para programar UI en Unity reutilizamos y
combinamos muchos componentes sencillos por medio del editor, cada uno
con una funcionalidad muy concreta, de modo que se van creando
estructuras más complejas, siguiendo la filosofía de la simplicidad.

### 4.2.2. La pantalla inicial

Es el momento de empezar a trabajar en la pantalla de inicio del juego.
En primer lugar, duplicamos el botón y renombramos ambos botones con los
nombres NewGame y Exit. A continuación, cambiamos el texto de cada
botón por los textos correspondientes, "Nueva partida" y "Salir". Para
ello, editamos su componente Text.

> Para duplicar un GameObject, se puede hacer cortar y pegar como en la
> mayoría de los editores.
>
> El nombre de un GameObject se cambia desde el Inspector.

Finalmente, situamos los botones centrados y separados de manera que no
se tapen el uno al otro. Podemos arrastrarlos visualmente mediante el
editor o asignar unas coordenadas concretas en el componente Transform
de cada uno de ellos:

- **NewGame:** Pos X = 0, Pos Y = 30, Pos Z = 0

- **Exit:** Pos X = 0, Pos Y = -30, Pos Z = 0

El resultado de estas operaciones es el siguiente:

![](images/part4/main_menu.png)

En estos momentos, si entramos en modo ejecución (pulsando el botón
Play), veremos que los botones se muestran correctamente y que se
pueden pulsar, aunque hacerlo no tiene ningún efecto asociado todavía.

### 4.2.3. _Scripting_ asociado a la UI

Para que nuestra UI lleve a cabo acciones concretas, será necesario
asociar a nuestros objetos de UI _scripts_ que implementen esas
acciones. Empezaremos creando el _script_ que responderá a la pulsación
del botón _Exit_ y que simplemente debe cerrar la aplicación.

> Para crear un _script_, debemos pulsar el botón derecho del ratón
> sobre el apartado de _Assets_ (pestaña _Project_) en el editor y
> seleccionar Create \> C\# Script.

| **Reto 1** |
| ---------- |

| Cread un _script_ llamado ExitGame con un único método llamado Exit que cuando sea llamado provoque que se muestre por consola el mensaje "Saliendo del juego...".

Una vez creado el _script_, lo añadiremos como componente al botón
Exit, simplemente arrastrándolo sobre el Inspector (o,
alternativamente, haciendo clic sobre el botón Add Component y
eligiendo el componente manualmente). Con esto, el _script_ pasa a
formar parte de este objeto.

> Los _scripts_ se asocian, generalmente, como componentes de los
> objetos del juego.

Ahora es necesario asociarlo a la acción propiamente de pulsar el botón
Exit. Para asociar código a la acción de pulsar un botón se debe asignar
vía un _listener_. Esto se lleva a cabo con el componente Button del
botón. En la parte inferior del Inspector aparece un recuadro donde se
listan los _listeners_ del evento OnClick.

> Un **_listener_** es el encargado de escuchar y controlar eventos.

Para añadir un _listener_ se debe pulsar el símbolo _+; entonces_,
aparece un apartado donde se puede indicar el _listener_, inicializado a None (Object) (ninguno). Sobre este cuadro se debe arrastrar desde la
Hierarchy el objeto que posee el código a ejecutar. En nuestro caso,
el objeto que contiene el _script_, que es el propio botón Exit. Una
vez arrastrado, es posible seleccionar en la caja desplegable contigua
el método que se ha de ejecutar. Para ello, primero se debe buscar el
componente adecuado (en este caso, nuestro _script_ GameExit), y luego
el método, tal y como muestra la siguiente imagen:

![](images/part4/exit_game.png)

Como podemos comprobar, Unity reconoce los métodos que contienen los
_scripts_, siempre que sean públicos y tengan una firma compatible con
el evento (que tengan los mismos parámetros y que devuelvan _void_). En
concreto, lo que hace Unity es enumerar los componentes del objeto que
se seleccione y listar todas las funciones compatibles. Gracias a esta
funcionalidad, podemos definir comportamientos de manera visual con el
editor.

Para comprobar que el proceso funciona correctamente, podemos entrar en
modo ejecución y pulsar el botón Exit. Una vez hecho esto, podemos
actualizar el código para que realmente provoque la salida del juego en
lugar de mostrar únicamente un mensaje en la consola.

| **Reto 2** |
| ---------- |

| Modificad el _script_ que realmente detendría el juego al pulsar el botón Exit. Para esta tarea, estudiad la documentación de la clase Application.

El motivo por el que hemos llevado a cabo esta tarea en dos pasos es que
la llamada al método que sale de la aplicación no tiene efecto dentro
del editor de Unity. Por lo tanto, no es posible probar realmente su
funcionamiento en modo ejecución.

Llega el momento a hacer la funcionalidad del otro botón, el de
_NewGame_. Antes, sin embargo, será necesario preparar el proyecto para
que exista una pantalla de juego (escena), que cargaremos al pulsar
dicho botón.

Para definirla, debemos guardar primero la escena actual mediante la
opción de menú File \> Save Scene, con el nombre MainMenu. Una buena
práctica es guardar las escenas juntas, en una carpeta Scenes, para
mantener un orden dentro del proyecto.

Seguidamente, crearemos una escena nueva con el menú File \> New Scene.
Al hacerlo, aparece una nueva pantalla vacía. La guardamos con el nombre
Game. De esta manera, Unity ya puede discriminar y cargar distintas
pantallas según su nombre. Sin embargo, aún no hemos terminado, porque
antes debemos indicar cuál es la primera escena que debe cargar Unity al
arrancar el juego.

La gestión de escenas en un proyecto se lleva a cabo mediante el menú
File \> Build Settings. En este menú podemos especificar diferentes
opciones sobre la generación del juego, como puede ser la plataforma
objetivo. En la parte superior (Scenes In Build) se encuentra la lista
de escenas que forman parte del juego. A esta lista podemos arrastrar
cualquier escena desde el apartado de _Assets_ del editor. La primera
escena de la lista será la primera que se cargará al iniciarse el juego.
El resto, se cargarán únicamente mediante código. Pero solo será posible
cargar escenas que se encuentren en esta lista explícitamente.

![](images/part4/build_settings.png)

¿Qué sentido tiene esta lista, más allá de la primera escena? Es
bastante frecuente en proyectos hacer escenas de prueba que no queremos
que acaben en la versión final. También hay muchos _assets_ en la Asset
Store que incluyen escenas para demostrar cómo se configuran o cómo
pueden mostrarse, que tampoco nos interesa que acaben en nuestro
ejecutable final, porque podrían inflar innecesariamente nuestra
aplicación. Así pues, de este modo podemos indicar qué escenas acaban
incluyéndose realmente en el juego final.

Una vez completado este paso, Unity ya podrá cargar nuestras escenas
correctamente.

> Cada vez que se carga una nueva escena, se destruyen todos los objetos
> de la anterior.

| **Reto 3** |
| ---------- |

| Haced que al pulsar el botón de nueva partida se cargue la escena Game. Para ello, cread un _script_ llamado NewGame con un único método llamado StartNewGame que lleve a cabo esta acción. Para esta tarea, estudiad la documentación de Unity sobre clase SceneManager.

Recordad que deberéis asociar el método al evento de pulsación del botón
mediante el _listener_ correspondiente.

| **Reto 4** |
| ---------- |

| Pensad qué deberíais hacer si, en vez de usar botones, quisierais usar texto (un GameObject tipo Text, en vez de Button) y que el usuario pudiera iniciar partida o salir del juego pulsando sobre él.

Ahora que ya sabemos cómo interactuar con una UI simple y cambiar de
escena, vamos a desarrollar la pantalla de juego de nuestro proyecto.

--> <a href="Parte4-3.md">Página siguiente</a>

<br /><hr />
