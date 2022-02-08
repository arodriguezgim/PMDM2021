# 4.3. La pantalla de juego

La pantalla de juego estará compuesta por dos secciones con elementos de
UI: una en la que tendremos el texto que describe nuestra situación y
otra en la que tendremos todas las opciones posibles de interacción del
jugador. Vamos a construir estas dos secciones en la escena Game, que
corresponderá a la pantalla de juego.

## 4.3.1. Configuración de la pantalla de juego

En primer lugar, vamos a Hierarchy y desplegamos el menú contextual con
el botón derecho del ratón sobre el Canvas. Mediante la opción UI \>
Text, creamos un elemento UI de texto. Para hacer que ocupe el espacio
que nos interesa, podemos usar las herramientas señaladas en la figura.
La señalada en la parte superior sirve para poder definir el tamaño de
los distintos elementos de UI en el editor de escena, a partir de los
puntos azules remarcados. La herramienta señalada con forma de triángulo
nos sirve para definir el anclaje del campo de texto. Especialmente en
los dispositivos móviles, hay una gran diversidad de tamaños de
pantallas y de proporciones; por ello, debemos situar los anclajes
correctamente para que nuestro UI se muestre correctamente en diferentes
dispositivos.

![](images/part4/ui_text.png)

> El **anclaje** (_anchoring_) de un elemento indica su comportamiento
> cuando se redimensiona la pantalla.

Vamos a añadirle también un fondo. Esta vez seleccionamos la opción UI
\> Image. Ajustamos el tamaño para que sea ligeramente más grande que el
texto y ajustamos los anclajes para que sean los mismos que los del
texto. Ahora podemos emparentar el texto a la imagen por comodidad.
Podemos también añadirle un fondo para que tenga los bordes un poco
suavizados. Para hacerlo, se debe asignar a la propiedad Source Image de
su componente Image. Podemos pulsar sobre el campo para abrir un
selector, o bien arrastrarla directamente desde al apartado de Assets
sobre el campo.

> Para poder añadir una imagen al objeto Image, esta antes ha de estar
> incluida dentro de los _assets_ del proyecto. En nuestro ejemplo,
> ponemos simplemente un fondo gris.

| **Reto 5** |
| ---------- |

|Buscad un fichero con una imagen de fondo que os guste y ponedla como fondo de la pantalla usando el objeto Image.

Además, vamos a añadir un pequeño título para que el jugador sepa
visualmente qué significa esta sección. Podemos duplicar los GameObjects
que hemos creado y ajustar el tamaño, para que se vean como un simple
detalle, y la posición, para que queden centrados y en la parte
superior. Si renombramos los GameObjects con nombres que reflejen el
significado de lo que representan, debería quedarnos una estructura como
la de la siguiente figura:

![](images/part4/story_section.png)

Ahora vamos a crear la sección de respuestas. El proceso será muy
similar al anterior, pero situaremos todo en la parte inferior de la
pantalla. También crearemos un botón, que hará de modelo de posible
respuesta. Existirá un botón por respuesta posible en cada escena. El
anclaje de este primer botón lo pondremos en la esquina superior
izquierda de la zona de respuestas.

![](images/part4/answers_section.png)

De este modo, tenemos los siguientes objetos de UI en la escena:

- **StoryText:** el texto que describe la situación actual al jugador.
- **StoryTitleText:** el título de la sección de historia.
- **AnswersTitleText:** el título de la sección de respuestas.
- **Button:** los botones de las posibles respuestas (de momento, solo uno).

A cada uno de estos objetos se le asocia una imagen de modo que, por su
relación en la _Hierarchy_, si se desplaza la imagen, también se
desplaza con ella el elemento de UI correspondiente.

Finalmente, vamos a generar un _prefab_ a partir del botón. La idea es
que el texto de la historia puede darnos varias opciones de respuesta, y
queremos poder instanciar un botón por cada una. Para hacerlo, la opción
más cómoda es usando _prefabs_. El tamaño del botón lo hemos dejado en
_Width = 150 y Height = 45, que_ parece un poco grande, pero así
permitimos respuestas un poco largas.

> Para crear un _prefab_ fácilmente, basta con arrastrar el objeto de la
> _Hierarchy_ al apartado de _Assets_. Su nombre quedará en azul.

Ya tenemos una primera configuración de la escena, pero aún quedan
algunos problemas que resolver. El primero es que el texto o los bordes
de las imágenes puede que se vean un poco borrosos. Esto se puede
solucionar marcando la opción Pixel Perfect, en el componente de Canvas,
dentro del GameObject con el mismo nombre.

Otro problema surge cuando el texto es demasiado largo y no cabe en el
espacio que hemos dejado para el texto de la historia. Necesitamos
entonces configurar una función de _scroll_. Para ello, primero
agrandamos el GameObject StoryText hacia abajo, de manera que sobresalga
claramente de la imagen que delimita el texto de la historia. Esto, como
es de esperar, causa que el texto se vea en zonas donde no debería
verse, pero es un paso previo a la solución final.

![](images/part4/answers_overflow.png)

Para solucionar el problema, vamos a crear un GameObject hijo de
StoryImage y hermano de StoryText. A este nuevo GameObject, al que vamos
a llamar MaskImage, le vamos a añadir una imagen mediante el componente
Image. Lo importante es que se defina el tamaño de manera que delimite
dónde se tendría que ver texto únicamente, es decir, debe ser un tamaño
ligeramente menor que el del GameObject StoryImage. Al GameObject
MaskImage le añadimos un componente Scroll Rect y otro Mask. El primero
le indica a Unity que todo el contenido que se asigne al campo Content
se puede desplazar en modo _scroll_. El segundo limita la visualización
de un objeto hijo en la Hierarchy, de modo que nunca ocupe más tamaño
que el objeto padre. Por lo tanto, tendremos que emparentar el contenido
que queramos delimitar con MaskImage.

En estos dos componentes, Scroll Rect y Mask, hay que configurar algunas
propiedades. De entrada, el componente Image está pintando una imagen
que realmente no nos interesa mostrar y que está tapando el contenido
que hay debajo. Para corregir esto, en el componente Mask desmarcamos la
opción Show Mask Graphic. Ahora que ya le hemos indicado a Unity cómo
funciona el _scroll_ y qué zonas se deben ver, debemos emparentar
correctamente el contenido. Como hemos dicho, los elementos hijos de
MaskImage son los que se verán correctamente. Por lo tanto, debemos
emparentar el GameObject StoryText al MaskImage, y entonces el texto ya
sí que solo se debería ver en las zonas que nos interesan.

Por otra parte, la propiedad Content del Scroll Rect se debe asignar al
GameObject StoryText (por ejemplo, arrastrando desde la Hierarchy) para
indicarle a Unity que este es el elemento que funciona en modo _scroll_.
En este mismo componente también deseleccionamos el campo Horizontal,
para que el _scroll_ solo sea vertical. Con todo esto, si al ejecutar el
juego ponemos un texto muy largo, podremos desplazarlo arrastrando el
contenido con el ratón. Por otro lado, es habitual definir barras de
_scroll_ para poder operar de una manera más intuitiva.

![](images/part4/scrollrect.png)

Por comodidad, se suelen poner las barras a los lados, para poder hacer
desplazamiento fácilmente. Esto se puede hacer añadiendo un objeto UI \>
Scrollbar en el Canvas, que representa una barra de desplazamiento.
Inicialmente, se nos mostrará una barra horizontal, que no es adecuada
para nuestro diseño. En el campo Direction, en su componente Scrollbar,
podemos seleccionar el sentido de la barra. En nuestro caso nos interesa
Bottom To Top.

Ahora debemos asignar este GameObject al campo Vertical Scrollbar del
componente Scroll Rect que hemos creado. Finalmente, ajustamos el tamaño
y la posición de la barra de _scroll_ para que quede situada cómodamente
en la parte derecha. Con todas estas operaciones deberíamos tener un
texto con desplazamiento, y probar el correcto funcionamiento apretando
Play.

![](images/part4/scrollbar.png)

En general, es una buena idea tener los GameObjects bien organizados y
por categorías. En ese sentido, a veces conviene tener GameObjects
vacíos (_empty_), que no tienen ninguna función en el juego pero que
hacen posible agrupar otros objetos de manera que formen una estructura
que permita tener ordenados los elementos de juego por grupos. Esto
mejora la legibilidad del proyecto.

| **Reto 6**                                                                                                                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Reorganizad la jerarquía usando objetos vacíos, de modo que al final quede todo ordenado según la figura de debajo. Dividiremos los elementos de la pantalla de juego según dos apartados: StorySection y AnswersSection. |

![](images/part4/organization.png)

## 4.3.2. Control del juego

Ahora que ya tenemos todos los elementos de la UI, ya podemos empezar a
crear la lógica del juego. Cuando tratamos lógica que no está claramente
asociada a un objeto concreto en la interfaz (por ejemplo, los botones
de la pantalla de inicio), lo normal es crear un GameObject vacío que
sirve como controlador o gestor del juego; este GameObject vacío no
tiene visualización en pantalla, solo sirve para agrupar ciertos scripts
generales. En este caso, llamaremos a dicho objeto _GameplayManager_ y
contendrá el _script_ con el código.

La estrategia que hay que seguir para controlar el juego será la
siguiente. Si bien podríamos generar tantas pantallas como
localizaciones tiene nuestro juego (si nuestro juego tiene diez
localizaciones, crear diez escenas en el proyecto), dado que todas las
pantallas van a tener un aspecto idéntico salvo en el texto explicativo
y las opciones disponibles, lo que haremos es trabajar sobre una sola
pantalla de juego y cambiar el contenido de los cuadros de texto según
corresponda. No tiene sentido ir replicando exactamente la misma escena,
ya que sería un trabajo sumamente tedioso e ineficiente.

> Las localizaciones del juego se corresponderían, de hecho, a las
> páginas de un libro de _Elige tu propia aventura_.

De cara a generar el código que controle las distintas localizaciones
del juego, el punto de partida será una estructura de datos en forma de
grafo dirigido que represente el mapa de localizaciones. Cada vértice es
una localización y sus aristas salientes son las distintas opciones,
cada una apuntando a su vértice destino.

El código del _script_ que define esta estructura de datos será el
siguiente:

```csharp
using System;

public class StoryNode
{
    public string History;
    public string[] Answers;
    public bool IsFinal;
    public StoryNode[] NextNode;
    public Action OnNodeVisited;
}

```

Este _script_ define una estructura de datos llamada _StoryNode_. A
partir de esta, generaremos el grafo y todo el contenido de las
localizaciones. Sus atributos son:

- **History:** el texto que describe la localización.

- **Answers\[\]:** la lista de textos con las respuestas posibles.

- **IsFinal:** indica que este nodo corresponde a un final, donde
  acaba la aventura.

- **NextNode\[\]:** la lista de nodos destino, en el mismo orden que
  en la lista de respuestas. Es decir, si se elige la respuesta en el
  índice 1 de _answers_, el jugador se desplazará al nodo indicado por
  _nextNode\[1\]._

- **OnNodeVisited:** permite asignar una referencia a un método
  delegado que se ejecutará siempre que se visite esa localización.
  Esta estrategia permite ejecutar código que manipule el mapa al
  llegar a ciertas localizaciones.

**Modificando el mapa en tiempo de ejecución**

En algunos momentos del juego será necesario modificar el mapa en tiempo
de ejecución. Por ejemplo, una ubicación puede tener una puerta cerrada,
que solo se podrá abrir si se ha cogido la llave correspondiente.

En un libro de _Elige tu propia aventura_, esto se resuelve normalmente
con un texto al estilo "Si tienes la llave, ves a la página ...; en
caso contrario, ves a la página ...". En nuestro juego, la estrategia
es la siguiente. Se van a crear dos nodos, uno que indica que la puerta
no se puede abrir (N1) y otro que representa que se abre con éxito (N2).
Inicialmente, el nodo asignado en _nextNode_ a la opción de abrir la
puerta es N1. Será en la localización que representa que se coge la
llave donde asignaremos el método delgado que reemplace N2 por N2, de
modo que, a partir de entonces, al llegar a la puerta, la acción de
abrir tendrá éxito automáticamente.

Además, en la clase GameplayManager existe el atributo CurrentNode,
que indicará en todo momento en qué nodo se encuentra actualmente el
jugador. El valor que se le asigne al iniciar el juego será la primera
localización.

Nuestra primera tarea será inicializar el mapa de localizaciones. En
este ejemplo, para simplificar, lo haremos de manera estática
directamente mediante código. Evidentemente, esta solución no es
escalable ni la mejor en un proyecto real. Sería mejor cargarlo desde un
fichero de datos estructurado, por ejemplo. Sin embargo, nuestra opción
a veces es una buena manera de generar prototipos rápidamente para
comprobar que todo funciona; más tarde se puede reformular si se
considera necesario.

La inicialización la llevará a cabo otro _script_ que llamaremos
_StoryFiller_ y que definirá una clase auxiliar que no se asignará a
ningún objeto. De este modo se separa la gestión del juego de la carga
de datos, manteniendo así el principio de encapsulación de código.

> Nótese que StoryFiller no hereda de MonoBehaviour, puesto que no
> es necesario.

```csharp
public static class StoryFiller
{
    public static StoryNode FillStory()
    {
        // Código de inicialización.
    }
}

```

Su valor de retorno es el nodo inicial, la que será la primera
localización del juego.

| **Reto 7** |
| ---------- |

| Rellenad el código del método FillStory de modo que generéis un mapa de localizaciones para el juego. Será necesario ir creando los nodos dinámicamente e inicializar sus atributos de algún modo.

Una vez tenemos el código que carga el mapa del juego, podemos
implementar el _script_ GameplayManager, que es el que realmente
gestionará la pantalla de juego. Su función principal será la de
actualizar la interfaz de usuario con los datos asociados a la ubicación
actual del jugador. Principalmente, actualizar los textos en pantalla,
eliminar los botones actuales y crear los nuevos que correspondan, según
el número de acciones disponibles en dicha localización.

Para destruir y crear objetos dinámicamente, Unity ofrece dos métodos.
Por una parte, Destroy elimina el objeto pasado como parámetro. Por
otra parte Instantiate crea objetos a partir de uno ya existente, que
es replicado. En este caso, sus parámetros son una referencia al objeto
a copiar, su posición y su rotación. Vale la pena destacar que dicho
método genera copias de objetos, no los crea realmente desde cero.
Normalmente lo que se hace no es copiar realmente un objeto ya
preexistente en la Hierarchy (lo que podría ser un problema si no hay
ningún otro objeto del mismo tipo aún creado), sino usar un _prefab_.

> Podéis ver todos los detalles de ambos métodos en la documentación
> oficial.

**Accediendo a _prefabs_ desde el código de un _script_**

Los _prefabs_ se crean desde la pantalla del editor y se guardan en
forma de _asset_ en el apartado Project. Una manera muy sencilla para
que vuestro código pueda acceder a dicho _prefab_ es la siguiente.
Primero, crear un atributo público de tipo GameObject en vuestro
_script_. Esto hace que en el Inspector, dentro del componente
Script, aparezca un campo asignable. Entonces, arrastrar el _prefab_
de Project a dicho apartado. A partir de ese momento, siempre que se
ejecute el _script_, en dicho atributo estará disponible el _prefab_.

En general, recordad que todo atributo declarado público en el código de
un _script_ aparece como un apartado asignable en su componente en el
editor, que puede ser inicializado arrastrando el elemento
correspondiente. Por ejemplo, si queremos tener un modo de acceso fácil
a un elemento de la UI (1) o a alguno de sus componentes, podemos hacer
exactamente lo mismo. Solo habrá que definir el atributo del tipo que
corresponda (por ejemplo, Text para un campo de texto, Transform para
una componente Transform, etc.). Unity dispone de tipos de datos para
prácticamente todos los elementos asociados a objetos en el editor.

(1) Las clases que representan los elementos de una UI en Unity están en > la biblioteca UnityEngine.UI.

Una vez creado un objeto a partir de un _prefab_, seguramente querremos
personalizar algunas de sus propiedades. Para ello, deberemos modificar
sus componentes, también dinámicamente. Para acceder a una componente de
un GameObject es necesario invocar su método GetComponent(). Por
ejemplo, para acceder al componente RectTransform de un elemento de UI,
se ejecutaría GetComponent\< RectTransform\>(). Una vez se dispone del
componente, es posible acceder y manipular todas sus propiedades
mediante los métodos y atributos públicos que ofrece.

Otro aspecto que deberemos gestionar dinámicamente es añadir _listeners_
a elementos de UI (en este caso, los nuevos botones), de modo que cada
nuevo botón nos desplace a la ubicación que corresponda. En este
sentido, los componentes de UI que esperan _listeners_ disponen de
atributos que permiten asignar referencias a métodos. Por ejemplo, el
componente Button dispone de la variable onClick, que a su vez dispone
del método AddListener.

> Recordad que el _listener_ se añade a un componente Button de un
> GameObject, no al objeto en sí.

Un ejemplo de código asociado a esta operación sería:

```csharp
var button = obj.GetComponent<Button>();
button.onClick.AddListener(() =>
{
    // Código del listener.
});

```

> Básicamente, es la misma sintaxis que en los métodos delegados.

Finalmente, otro mecanismo muy útil a la hora de gestionar objetos por
medio de un _script_ es poder recorrer los elementos de su jerarquía de
acuerdo con la estructura mostrada en la Hierarchy del editor. Esta
tarea se puede llevar a cabo mediante el componente Transform de un
objeto:

```csharp
var parent = obj.GetComponent<Transform>();
foreach (Transform child in parent)
{
    // Código que manipula sus hijos vía la variable child.
}

```

> Recordad que toda manipulación del componente Transform de un objeto
> se hereda a todos los hijos en la jerarquía.

Relacionado con este mecanismo de recorrido, el componente Transform
posee también el atributo _parent_, que contiene su padre en la
jerarquía. Asignando el valor correspondiente es posible crear
relaciones padre-hijo.

> El atributo gameObject contiene el objeto asociado al Transform en
> cuestión.

| **Reto 8**                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Completad la clase GameplayManager. Primero, debe encargarse de generar el mapa al inicio de la partida. Pensad qué método debe incorporar dicho código. Inmediatamente después, debe inicializar la UI con los datos de la primera ubicación. A partir de aquí, debe encargarse de actualizar la ubicación del personaje y mostrar los nuevos datos en la UI cada vez que se pulsa alguno de los botones que enumeran las acciones disponibles. |

--> <a href="Parte4-4.md">Página siguiente</a>

<br /><hr />
