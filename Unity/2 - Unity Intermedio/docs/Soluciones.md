
# Soluciones

## Reto 1

Una posible configuración de los componentes sería la siguiente:

![](images/solutions/bike_colliders.png)

## Reto 2

Para importar correctamente un *sprite* con múltiples imágenes es
necesario seleccionar Sprite Mode Multiple. Entonces, en el editor de
*sprites*, debemos seleccionar Slice y la opción Type como Grid By Cell
Size, con Pixel Size igual a 64 x 64.

![](images/solutions/multiple_sprite_slice.png)

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

## Reto 3


Hemos añadido un delegado más, para diferenciar cuál es el objeto con el
que hemos colisionado (si es el diamante o no).


```csharp
public class BikeController : MonoBehaviour
{
    public Action OnKilled;
    public Action OnReachedEndOfLevel;
    
    // ...

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.CompareTag("EndOfLevel"))
            OnReachedEndOfLevel?.Invoke();
        else
            OnKilled?.Invoke();
    }
}
```

## Reto 4

Si en el editor asignamos al motorista en el campo correspondiente del
*script* GameplayManager, veremos que cada vez que se da la vuelta el
nivel se reinicia.

```csharp
public class GameplayManager : MonoBehaviour
{
    // ...

    private void Start()
    {
        motoristaController.OnKilled += RestartLevel;

        // ...
    }

    public void RestartLevel()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }
}
```

## Reto 5

Podemos crear objetos que contengan un BoxCollider2D y el siguiente componente:

```csharp
using UnityEngine;

public class DeadZone : MonoBehaviour
{
    public GameplayManager GameplayManager;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Bike"))
        {
            GameplayManager.RestartLevel();
        }
    }
}
```

Situaremos estos objetos en los agujeros del nivel, para detectar todos los posibles lugares en los que puede caer el motorista.

## Reto 6

Simplemente debemos añadir el siguiente *script* a la cámara y asignar el motorista al campo correspondiente en el editor:

```csharp
using UnityEngine;

public class BikeFollower : MonoBehaviour
{
    public Transform Bike;

    private Vector3 offset;

    private void Start()
    {
        offset = Bike.transform.position - transform.position;
    }

    private void Update()
    {
        transform.position = Bike.position - offset;
    }
}
```

## Reto 7

Este es el *script* GameplayManager completo:

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

        recordTime = PlayerPrefs.GetFloat("recordLevel" + SceneManager.GetActiveScene().buildIndex, 0);

        if (recordTime > 0)
            RecordText.text = "Record: " + recordTime.ToString("00.00") + "s";
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

        if ((Time.time - initialTime) < recordTime)
        {
            PlayerPrefs.SetFloat("recordLevel" + SceneManager.GetActiveScene().buildIndex, (Time.time - initialTime));
            TimeText.text = "NEW RECORD! " + (Time.time - initialTime).ToString("00.00") + "s";
        }
        else
        {
            TimeText.text = "FINAL! " + (Time.time - initialTime).ToString("00.00") + "s";
        }
    }
}
```
