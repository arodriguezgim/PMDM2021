
# 3.5. El UI

Ahora vamos a gestionar el caso de éxito y mostrar el tiempo
transcurrido en una interfaz, guardando el récord. En primer lugar,
hemos añadido un botón hijo del GameObject Canvas mediante Menú \>
GameObject \> UI \> Button. El botón por defecto nos muestra un sprite
(en el campo Source Image) que no nos interesa en este caso. Lo podemos
borrar y cambiar el alfa del campo Color a 0, de manera que nos
quedará transparente. El texto del botón, que está como hijo del botón,
tiene una fuente por defecto que vamos a cambiar. En el campo Text
pondremos Start, para indicar que hay que pulsarlo para empezar.

![](images/part3/start_button_text.png)

También añadiremos un campo de texto mediante Menú \> GameObject \> UI
\> Text, en el que realizaremos las mismas operaciones, pero le
pondremos un tamaño de fuente un poco más pequeño, por ejemplo 14. La
idea es que nos queden centradas y en la parte superior, como en la
siguiente figura:

![](images/part3/ui_text.png)

Ahora hay que controlar estos elementos para que muestren lo que nos
interesa. Para ello, podemos modificar el *script* GameplayManager
definido en los retos anteriores de la siguiente manera:

```csharp
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class GameplayManager : MonoBehaviour
{
    public BikeController BikeController;
    public Text TimeText;
    public Text RecordText;
    public Button StartButton;

    private float initialTime;
    private float recordTime;
    private int secondsToStart = 3;

    private void Start()
    {
        TimeText.text = RecordText.text = string.Empty;

        BikeController.OnKilled += RestartLevel;
        BikeController.OnReachedEndOfLevel += EndGame;
        BikeController.enabled = false;
    }

    private void Update()
    {
        if (BikeController.enabled)
        {
            TimeText.text = "Time: " + (Time.time - initialTime).ToString("00.00") + "s";
        }
    }

    public void StartGame()
    {
        StartButton.gameObject.SetActive(false);

        TimeText.text = secondsToStart.ToString();
        InvokeRepeating(nameof(Countdown), 1, 1);
    }

    private void Countdown()
    {
        secondsToStart--;
        if (secondsToStart <= 0)
        {
            CancelInvoke();
            OnGameStarted();
        }
        else
            TimeText.text = secondsToStart.ToString();
    }

    public void RestartLevel()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }

    private void OnGameStarted()
    {
        BikeController.enabled = true;
        initialTime = Time.time;
        TimeText.text = string.Empty;
    }

    private void EndGame()
    {
        StartButton.gameObject.SetActive(true);

        BikeController.enabled = false;
        TimeText.text = "FINAL! " + (Time.time - initialTime).ToString("00.00") + "s";
    }
}
```

En esta versión del *script* hay algunos conceptos que no hemos visto.
Por ejemplo, InvokeRepeating es un método propio de Unity que se encarga
de llamar al método que le indiquemos cada cierto tiempo. Se podría
implementar de múltiples maneras, pero esta es muy cómoda en este caso.
Llamamos a Countdown hasta que nuestro contador llega a 0, y cancelamos
el InvokeRepeating.


También proponemos usar
[PlayerPrefs](https://docs.unity3d.com/ScriptReference/PlayerPrefs.html),
que es un equivalente a una pequeña base de datos que gestiona Unity.
Podemos guardar números enteros, números con decimales o texto. En este
caso, es muy adecuado para guardar el récord de tiempo del usuario.


| **Reto 7** |
| ---    |
| Modificad el *script* para guardar el récord de tiempo del usuario usando PlayerPrefs. |

Ahora asignamos al evento OnClick del botón Start que acabamos de crear
el método StartGame, de esta manera el jugador podrá intentar llegar al
diamante rosa, y si lo consigue se guardará el *record*. Si no, la
partida se reiniciará. Tenemos un nivel del juego completo, podemos
ahora intentar modificar y mejorar el juego añadiendo otros niveles.
