# Soluciones

## Reto 1

```csharp
using UnityEngine;

public class ExitGame : MonoBehaviour
{
    public void Exit()
    {
        Debug.Log("Saliendo del juego...");
    }
}
```

## Reto 2

```csharp
using UnityEngine;

public class ExitGame : MonoBehaviour
{
    public void Exit()
    {
        Application.Quit();
    }
}
```

## Reto 3

```csharp
using UnityEngine;
using UnityEngine.SceneManagement;

public class NewGame : MonoBehaviour
{
    public void StartNewGame()
    {
        SceneManager.LoadScene("Game");
    }
}
```

## Reto 4

El aspecto que hace que un objeto se comporte como un botón (y, por
ejemplo, pueda ser pulsado) es el hecho de que contenga un componente de
tipo Button. Por lo tanto, si queremos que un bloque de texto, un
objeto de tipo Text, se comporte de este modo, basta con añadirle
dicho componente mediante el botón Add Component del Inspector.

## Reto 5

Primero, es necesario añadir el fichero de imagen al proyecto como
_asset_. En caso contrario, Unity no podría encontrarlo. No busca en el
sistema de ficheros, sino únicamente entre los ficheros del proyecto.
Para hacerlo, basta con arrastrar el fichero desde el explorador del
sistema al apartado _Assets_ de Unity, que lo importará automáticamente.
Entonces, hay que arrastrar el nuevo _asset_ sobre la propiedad Source
Image del componente Image.

## Reto 6

Para reorganizar los objetos, basta con crear dos nuevos GameObjects
vacíos dentro del Canvas (opción de menú Create Empty) con los nombres
indicados. Entonces, hay que arrastrar los elementos ya existentes,
manteniendo la relación jerárquica entre ellos, de modo que los dos
nuevos objetos sean los únicos nodos que cuelgan directamente del
Canvas.

## Reto 7

Un ejemplo de mapa de localizaciones podría ser el siguiente. En este
caso, usamos un método estático (CreateNode) para construir los nodos a
partir de dos parámetros: el texto de la localización y la lista de
opciones, como array de _string_. El resto de atributos se asignan
directamente, aprovechando que han sido declarados como públicos.

```csharp
public static class StoryFiller
{
    public static StoryNode FillStory()
    {
        var root = CreateNode(
            "Te encuentras en una habitación y no recuerdas nada. Quieres salir",
            new [] {
            "Explorar objetos",
            "Explorar habitación"});

        var node1 = CreateNode(
            "Hay una silla y una mesa con una planta a la izquierda. " +
            "A la derecha hay una estanteria con libros. " +
            "Detrás parece que hay cunas cajas.",
            new [] {
            "Ir a la derecha",
            "Ir a la izquierda",
            "Ir hacia atrás",
            "Explorar habitación"});

        var node2 = CreateNode(
            "Nada interesante... " +
            "Aunque hay un libro que llama la atención... " +
            "¿Botánica para astronautas?",
            new [] {
            "Explorar el resto de la habitación",
            "Averiguar más del libro raro."});

        var node3 = CreateNode(
           "Parece que habla de plantas, qué sorpresa. " +
           "Hay una señalada, se llama plantus corrientis.",
           new [] {
            "Dejar el libro en su sitio y explorar el resto de objetos de la habitación."});

        var node4 = CreateNode(
           "Nada interesante en las cajas, están llenas de libros... " +
           "Deberían estar en la estantería.",
           new [] {
            "Volver y explorar el resto de objetos de la habitación."});

        var node5 = CreateNode(
           "Humm, una silla. Te duele la cabeza, así que te sientas.",
           new [] {
            "Quiero ver lo de la mesa también."});

        var node6 = CreateNode(
            "La mesa en sí no tiene nada de especial, tiene un poco de tierra de la planta. " +
            "Los cajones de la mesa parecen entreabiertos.",
            new [] {
            "Explorar los cajones.",
            "Volver a explorar los otros objetos"});

        var node6Bis = CreateNode(
           "La mesa en sí no tiene nada de especial, tiene un poco de tierra de la planta. " +
           "La etiqueta de la planta pone plantus corrientis. " +
           "Los cajones de la mesa parecen entreabiertos.",
           new [] {
            "Explorar los cajones.",
            "Mirar la planta de cerca.",
            "Volver a explorar los otros objetos"});

        var node7 = CreateNode(
          "Los cajones están vacíos, mejor explorar otra cosa.",
          new [] {
            "Volver a explorar los otros objetos"});

        var node8 = CreateNode(
           "¡¡Al levantar la planta encuentras una llave!! ¿Qué abrirá?",
           new [] {
            "Explorar la habitación"});

        var node9 = CreateNode(
          "La habitación tiene un par de ventanas y una puerta.",
          new [] {
            "Ir a la ventana #1",
            "Ir a la ventana #2",
            "Ir a la puerta"});

        var node10 = CreateNode(
          "La ventana está tapiada, no se puede abrir.",
          new [] {
            "Ir a la otra ventana",
            "Ir a la puerta"});

        var node11 = CreateNode(
          "La puerta está cerrada con un candado.",
          new [] {
            "Explorar los objetos de la habitación"});

        var node11Bis = CreateNode(
          "La puerta está cerrada con un candado.",
          new [] {
            "Explorar los objetos de la habitación",
            "Usar la llave"});

        var node12 = CreateNode(
          "¡¡Has salido de la habitación!!",
          new [] {
            "Salir del juego"});

        root.NextNode[0] = node1;
        root.NextNode[1] = node9;

        node1.NextNode[0] = node2;
        node1.NextNode[1] = node5;
        node1.NextNode[2] = node4;
        node1.NextNode[3] = node9;

        node2.NextNode[0] = node1;
        node2.NextNode[1] = node3;

        node3.NextNode[0] = node1;
        node3.OnNodeVisited = () =>
        {
            node5.NextNode[0] = node6Bis;
        };

        node4.NextNode[0] = node1;

        node5.NextNode[0] = node6;

        node6.NextNode[0] = node7;
        node6.NextNode[1] = node1;

        node6Bis.NextNode[0] = node8;
        node6Bis.NextNode[1] = node1;

        node7.NextNode[0] = node1;

        node8.NextNode[0] = node9;
        node8.OnNodeVisited = () =>
        {
            node9.NextNode[2] = node10.NextNode[1] = node11Bis;
        };

        node9.NextNode[0] = node9.NextNode[1] = node10;
        node9.NextNode[2] = node11;

        node10.NextNode[0] = node10;
        node10.NextNode[1] = node11;

        node11.NextNode[0] = node1;

        node11Bis.NextNode[0] = node1;
        node11Bis.NextNode[1] = node12;

        node12.IsFinal = true;

        return root;
    }

    private static StoryNode CreateNode(string history, string[] options)
    {
        var node = new StoryNode
        {
            History = history,
            Answers = options,
            NextNode = new StoryNode[options.Length]
        };
        return node;
    }
}
```

## Reto 8

Un posible código para gestionar el juego es el siguiente. Nótese como
se añaden algunos atributos (HistoryText, AnswersParent, ButtonAnswer)
que, inicializados correctamente desde el editor, permiten acceder a
ciertos elementos del proyecto (_prefabs_, elementos de la UI) desde el
_script_.

De cara a destruir los botones existentes, la estrategia es la
siguiente. Se guarda en un atributo (ButtonAnswer) con el GameObject
padre en la jerarquía de botones. Entonces, por medio de su componente
Transform, es posible recorrer los componentes Transform de todos los
botones existentes y manipularlos.

Al crear botones nuevos, estos se añaden a la jerarquía de nuevo
asignando ButtonAnswer como padre a cada uno de sus componentes
Transform.

```csharp
using UnityEngine;
using UnityEngine.UI;

public class GameplayManager : MonoBehaviour
{
    public Text HistoryText;
    public Transform AnswersParent;
    public GameObject ButtonAnswerPrefab;

    private StoryNode currentNode;

    private void Start()
    {
        currentNode = StoryFiller.FillStory();
        HistoryText.text = string.Empty;
        FillUi();
    }

    void FillUi()
    {
        HistoryText.text += "\n\n" + currentNode.History;

        foreach (Transform child in AnswersParent.transform)
        {
            Destroy(child.gameObject);
        }

        var isLeft = true;
        var height = 50.0f;
        var index = 0;
        foreach (var answer in currentNode.Answers)
        {
            var buttonAnswerCopy = Instantiate(ButtonAnswerPrefab, AnswersParent, true);

            var x = buttonAnswerCopy.GetComponent<RectTransform>().rect.x * 1.3f;
            buttonAnswerCopy.GetComponent<RectTransform>().localPosition = new Vector3(isLeft ? x : -x, height, 0);

            if (!isLeft)
                height += buttonAnswerCopy.GetComponent<RectTransform>().rect.y * 3.0f;
            isLeft = !isLeft;

            FillListener(buttonAnswerCopy.GetComponent<Button>(), index);

            buttonAnswerCopy.GetComponentInChildren<Text>().text = answer;

            index++;
        }
    }

    private void FillListener(Button button, int index)
    {
        button.onClick.AddListener(() => { AnswerSelected(index); });
    }

    private void AnswerSelected(int index)
    {
        HistoryText.text += "\n" + currentNode.Answers[index];

        if (!currentNode.IsFinal)
        {
            currentNode = currentNode.NextNode[index];

            currentNode.OnNodeVisited?.Invoke();

            FillUi();
        }
        else
        {
            HistoryText.text += "\n" + "TOCA ESCAPE PARA CONTINUAR";
        }
    }
}
```

## Reto 9

Ver las soluciones a los retos 2 y 3. De hecho, podemos volver a usar el
_script_ del caso de iniciar partida, no es necesario crear un nuevo. Sí
será necesario para volver a la pantalla de inicio.

## Reto 10

Para llevar a cabo esta tarea, hay que controlar constantemente la
entrada del jugador para ver si este pulsa la tecla _Esc_. Por lo tanto,
se debe usar el método Update para, en cada _frame_ del juego, ver si
dicha tecla ha sido pulsada.

```csharp
using UnityEngine;
using UnityEngine.SceneManagement;

public class PauseScreenManager : MonoBehaviour
{
    public GameObject PauseScreen;

    public void LoadMainMenu()
    {
        SceneManager.LoadScene("MainMenu");
    }

    public void RestartGame()
    {
        SceneManager.LoadScene("Game");
    }

    private void Update()
    {
        if (Input.GetKeyUp(KeyCode.Escape))
            PauseScreen.SetActive(!PauseScreen.activeSelf);
    }
}
```

## Reto 11

Podéis elegir la música que más os guste. A continuación, cargamos la
_scene_ MainMenu, seleccionamos el GameObject Main Camera y le añadimos
un componente AudioSource. Una vez añadido, arrastramos el _asset_ desde
Project al campo AudioClip del componente. Finalmente, seleccionamos las
opciones Loop y Play On Awake. De esta manera, nada más empezar el juego
ya estará sonando la música de fondo, y esta se repetirá automáticamente
cuando se acabe.

Si hacemos la misma operación para cada escena cambiando solo la pista
de audio que asignamos a cada AudioSource, tendremos ya toda la música
de fondo en nuestro proyecto. Dado que cada vez que se carga una escena
se destruyen los objetos de la anterior y se crean los de la nueva, esto
garantiza que se reproduzca una única música en cada pantalla.

## Reto 12

La opción para llevar a cabo esta tarea es mediante la plataforma WebGL.
