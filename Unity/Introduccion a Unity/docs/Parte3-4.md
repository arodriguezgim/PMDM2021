# 3.4. Clases auxiliares

Unity proporciona una extensa colección de librerías para facilitarnos
la programación de nuestros proyectos. En este apartado vamos a enumerar
brevemente las más relevantes, con el simple propósito de dar a conocer
su existencia; la explicación más detallada se encuentra en la
documentación oficial. En este sentido, los ejemplos incluidos solo
sirven para dar una visión más clara del propósito de cada clase.

## 3.4.1. La clase Input

Esta clase nos permite reconocer la entrada del jugador en varios
dispositivos (teclado, ratón, _gamepad_, pantalla táctil, etc.). Veamos
algunos ejemplos de cómo usar esta clase:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
            Debug.Log("Space key was pressed.");
    }
}
```

> **KeyCode** contiene toda una serie de constantes que definen las
> distintas teclas del teclado (Space, F1, Asterisk, A, etc.).

En este _script_, comprobamos en cada _frame_ si el jugador ha pulsado
la tecla espaciadora en su teclado. De ser así, escribimos el mensaje
"Space key was pressed" en la consola. Nótese el uso del método
Update para poder reconocer la entrada del jugador en cada _frame_.

Veamos otro ejemplo:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Update()
    {
        if (Input.touchCount > 0 && Input.GetTouch(0).phase == TouchPhase.Moved)
            Debug.Log("Screen was touched.");
    }
}
```

En este _script_, comprobamos en cada _frame_ si el jugador ha movido el
dedo sobre la pantalla táctil de su dispositivo. De ser así, escribimos
el mensaje "Screen was touched" en la consola. Por supuesto, si el
dispositivo en cuestión no dispone de pantalla táctil, esto no ocurrirá
nunca. Para simular un dispositivo táctil, podemos descargar desde el
package manager el paquete con el nombre "Device Simulator".

> [Device Simulator](https://docs.unity3d.com/Packages/com.unity.device-simulator@2.2/manual/index.html).

Para poder descargar el package del device simulator en la versión 2020.1.4f1 hay que acceder a Project Settings / Package Manager y activar el check “Enable Preview Packages”.

![Seleccionar Advanced Project Setting](images/part2/device_simulator_1.png)

![Activar Preview Packages](images/part2/device_simulator_2.png)

_Input_ es una clase muy extensa con multitud de funcionalidades.
Siempre que necesitemos obtener algún tipo de dato de interacción del
jugador no cubierta en este capítulo (giroscopio, brújula, localización,
etc.), podemos acudir a la documentación oficial de Unity.

> Podemos encontrar la documentación oficial de la clase _Input_ > [aquí](https://docs.unity3d.com/ScriptReference/Input.html).

### Consejos sobre Input en juegos dirigidos a múltiples plataformas

Unity es un motor multiplataforma, como lo son muchos juegos en la
actualidad. Si nuestro juego está dirigido a varias plataformas con
mecanismos de entrada diferentes, será necesario crear nuestra propia
capa de abstracción para detectar la entrada del usuario de la manera
adecuada según la plataforma (por ejemplo, con _gamepad_ en consolas y
con los dedos sobre la pantalla táctil en móviles).

## 3.4.2. La clase Application

Esta clase nos permite acceder a una gran cantidad de información sobre
el dispositivo en el que se está ejecutando nuestro juego.

Veamos un ejemplo:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Update()
    {
        Debug.Log($"The current platform is {Application.platform}");
        if (Application.platform == RuntimePlatform.WindowsPlayer)
            Debug.Log("The current platform is Windows.");
    }
}
```

> **RuntimePlatform** contiene toda una serie de constantes que definen
> las distintas plataformas disponibles en Unity (PC, PS4, iOS, etc.).

En este ejemplo, primero mostramos por consola la plataforma en la que
se está ejecutando el juego. Después, si se da el caso de que estamos en
Windows, enseñamos por pantalla un mensaje específico. Hay que tener en
cuenta que dentro del editor no estamos en RuntimePlatform.WindowsPlayer
sino en RuntimePlatform.WindowsEditor.

> Podemos encontrar la documentación oficial de la clase Application
> [aquí](https://docs.unity3d.com/ScriptReference/Application.html).

## 3.4.3. La clase Time

Programando la lógica de un juego, en muchas ocasiones queremos hacer
operaciones que no dependan del número de _frames_ que el dispositivo es
capaz de obtener. Por ejemplo, una animación debería empezar y acabar en
el mismo momento, o un juego de carreras debería desplazar los coches
según la velocidad del vehículo y no según los FPS. Hay que tener en
cuenta que es bastante frecuente tener grandes variaciones en los FPS
que conseguimos, sobre todo cuando cambiamos de perspectiva en la escena
y hay partes con mucho detalle y otras muy simples. Para todo este tipo
de operaciones, tenemos a nuestra disposición la clase _Time_, que nos
permite controlar el tiempo que ha transcurrido entre diferentes
eventos, como puede ser entre dos _frames_ consecutivos.

Veamos un ejemplo de uso:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    private void Update()
    {
        transform.Translate(0, 0, Time.deltaTime * 1);
    }
}
```

> El método **Transform.Translate** permite mover el GameObject
> asociado.
>
> **Time.deltaTime** indica el tiempo que ha transcurrido entre la
> ejecución del último _frame_ y el actual.

Este _script_ hace que el GameObject asociado se traslade una unidad
por segundo en el eje Z. En cada _frame_ (de ahí que utilicemos el
método Update), el objeto se desplaza la cantidad de tiempo que ha
pasado entre dos _frames_. Si tenemos FPS muy altos, Time.deltaTime
será una cantidad muy pequeña a cada ejecución, por lo que el objeto se
moverá muy poco, y viceversa. Independientemente de los FPS, solo se
desplazará una unidad cuando haya pasado un segundo completo.

> La variable Time.deltaTime es de gran utilidad, ya que, usada como
> factor de corrección, permite ejecutar cualquier funcionalidad
> independientemente de los FPS reales del juego.
>
> Podemos encontrar la documentación oficial de la clase Time
> [aquí](https://docs.unity3d.com/ScriptReference/Time.html).

--> <a href="Parte3-5.md">Página siguiente</a>

<br /><hr />
