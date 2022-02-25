

# 2.3. *Scripting* con físicas 2D

El *scripting* de físicas sigue la misma filosofía que la generación de
*frames*; está basado en eventos que recibimos en un objeto
MonoBehaviour y que procesamos definiendo el método adecuado.

En este caso, podemos gestionar dos tipos de eventos en caso de que se
produzca una colisión entre objetos:

-   **OnCollisionEnter2D(Collision2D coll)**: en caso de que se produzca
    una colisión entre objetos y ninguno de ellos tenga marcada la
    propiedad *Is Trigger.*

-   **OnTriggerEnter2D(Collider2D other)**: en caso de que un objeto
    marcado como *Is Trigger reciba* una colisión.

A continuación tenemos un ejemplo de *script* que podemos añadir a un
GameObject que tenga un Collider2D, de modo que lance un mensaje de
depuración al recibir una colisión:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void OnCollisionEnter2D(Collision2D coll)
    {
        Debug.Log("Collision!");
    }
}
```

Podemos probar a crear dos GameObjects en una escena vacía, añadirles un
BoxCollider2D a cada uno, y añadirle un Rigidbody2D junto con este
*script* a uno de ellos. Luego pulsamos Play y con el ratón podemos
hacer que colisionen moviendo los objetos en la escena. Comprobaremos
que en la pestaña Console aparecerá el mensaje "Collision!".

En caso de querer probar el efecto de Is Trigger, podemos activar dicho
parámetro en alguno de los Collider2D. En ese caso, podemos modificar el
*script* anterior de la siguiente manera:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void OnCollisionEnter2D(Collision2D coll)
    {
        Debug.Log("Physics collision!");
    }
    
    private void OnTriggerEnter2D(Collider2D other)
    {
        Debug.Log("Trigger collision!");
    }
}
```
