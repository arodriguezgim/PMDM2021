# 3.2. Métodos importantes en Unity

Los motores de juegos nos proporcionan maneras de programar lo que
queremos hacer durante la inicialización del juego y durante cada
_frame_ del mismo. En el caso de Unity, el motor se encarga de llamar en
los momentos adecuados a los métodos Start y Update, entre otros, de los
_scripts_ asociados a cada GameObject de la escena actual. De este modo,
podemos controlar lo que ocurre en cada instante de nuestro juego. A
continuación, veremos en detalle cómo se usan estos métodos con algunos
ejemplos prácticos.

## 3.2.1. Awake y Start

Estos métodos se ejecutan una sola vez por componente del objeto.
Específicamente, justo después de crear dicho componente. En estos
métodos vamos a encontrar, habitualmente, código relacionado con la
inicialización del componente. Incluyendo también el almacenamiento de
datos por motivos de rendimiento (normalmente, para no tener que
ejecutar llamadas o cálculos costosos cada _frame_ sino hacerlo una sola
vez al principio). La diferencia entre Awake y Start es que utilizaremos
el primero para la inicialización local del componente y el segundo para
la inicialización externa del mismo (esto es, cálculos o llamadas
relacionados con otros objetos). El Awake siempre se ejecuta antes del
Start.

Veamos un pequeño ejemplo de _script_:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Awake()
    {
        Debug.Log("Hello world, from Awake!");
    }

    private void Start()
    {
        Debug.Log("Hello world, from Start!");
    }
}
```

> El método Debug.Log permite escribir texto por la consola durante la
> ejecución de un _script_ de Unity.

Como ya habíamos comentado anteriormente, nuestro _script_ de ejemplo es
una clase que hereda de MonoBehaviour, que es una clase definida
internamente por Unity. Esta clase la hemos llamado ExampleClass y
contiene dos métodos. El objeto que contenga este _script_ escribirá una
sola vez por consola, al inicio de la ejecución, los mensajes de texto
"Hello world, from Awake!" y "Hello world, from Start!", en ese
orden.

Como comentamos anteriormente, es importante que el _script_ que
contenga esta clase se llame igual que esta (es decir, ExampleClass.cs).

## 3.2.2. Update

Este método es uno de los más importantes porque se ejecuta una vez por
_frame_, justo antes de mostrar la imagen final resultante en pantalla.

Es muy importante que esta función sea lo más óptima posible. Es muy
fácil incurrir en costes excesivos que afecten a la experiencia final
del juego; por ejemplo, realizando operaciones complejas cada _frame_
que podrían realizarse una única vez en tiempo de inicialización, a lo
largo de varios _frames_ o cada cierto número de _frames_.

Veamos un ejemplo sencillo de _script_ con la función Update:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Update()
    {
        Debug.Log("Updating...");
    }
}
```

Este _script_ escribe el mensaje "Updating..." en cada _frame_ y por
cada GameObject al cual esté añadido. Así pues, si nuestro juego se
ejecuta a 30 FPS, el mensaje se escribirá treinta veces por segundo.

## 3.2.3. OnEnable y OnDisable

Estas funciones se ejecutan cada vez que un _script_ se activa
(incluyendo el momento en que el _script_ se añade a un objeto) o se
desactiva. Puede tener sentido desactivar temporalmente un _script_ si
queremos que deje de ejecutar su código momentáneamente. En caso de
querer que el _script_ deje de ejecutarse definitivamente, lo más
adecuado es eliminarlo mediante el editor o vía programación con el
método
[Destroy](https://docs.unity3d.com/ScriptReference/Object.Destroy.html).

> Un _script_ se activa o desactiva mediante el _checkbox_ de la lista
> de componentes del Inspector.

Veamos un ejemplo:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void OnEnable()
    {
        Debug.Log("Script was enabled.");
    }

    private void OnDisable()
    {
        Debug.Log("Script was disabled.");
    }
}
```

En este caso, al entrar en modo ejecución veremos el mensaje "Script
was enabled" en la consola de Unity. Si vamos al Inspector y hacemos
clic en el _checkbox_ que activa/desactiva el _script_, veremos por
consola que cada vez que activamos el _script_ se nos muestra el mensaje
"Script was enabled" y que cuando desactivamos el _script_ se nos
muestra "Script was disabled".

Al salir del modo ejecución también veremos el mensaje "Script was
disabled", ya que, justo antes de salir de este modo, todos los
componentes llaman a su OnDisable.

--> <a href="Parte3-3.md">Página siguiente</a>

<br /><hr />
