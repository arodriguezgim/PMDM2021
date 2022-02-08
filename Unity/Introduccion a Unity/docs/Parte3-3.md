# 3.3. Edición de campos en el Inspector

Los campos (_fields_) de tipos básicos declarados como públicos de una
clase que derive de _MonoBehaviour_ tienen una propiedad muy interesante
para los desarrolladores, y es que podemos ver y configurar su valor
visualmente mediante el editor de Unity, en la pestaña Inspector.

> **\*bool**, **int**, **float\*** y **_string_** se consideran tipos
> básicos, por ejemplo.

Veamos un ejemplo. Supongamos el siguiente _script_:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    public bool TestBool;
    public int TestInt;
    public float TestFloat;
    public string TestString;

    private void Start()
    {
        Debug.Log($"TestBool = {TestBool}");
        Debug.Log($"TestInt = {TestInt}");
        Debug.Log($"TestFloat = {TestFloat}");
        Debug.Log($"TestString = {TestString}");
    }
}
```

En este caso, los campos públicos son TestBool, TestInt, TestFloat y
TestString. Si asignamos este _script_ a un objeto y echamos un vistazo
al componente que corresponde al _script_ en la pestaña Inspector,
veremos que los cuatro campos aparecen reflejados y podemos modificarlos
directamente. Si pulsamos el botón _Play_ para ejecutar el programa, se
nos mostrarán por consola los valores que hemos introducido
anteriormente.

Unity también muestra en el editor aquellos campos que se definan con el
atributo \[SerializeField\]. El ejemplo anterior lo podemos modificar
de la siguiente manera:

```csharp
using UnityEngine;

public class ExampleClass : MonoBehaviour
{
    [SerializeField]
    private bool testBool;
    [SerializeField]
    private int testInt;
    [SerializeField]
    private float testFloat;
    [SerializeField]
    private string testString;

    private void Start()
    {
        Debug.Log($"TestBool = {testBool}");
        Debug.Log($"TestInt = {testInt}");
        Debug.Log($"TestFloat = {testFloat}");
        Debug.Log($"TestString = {testString}");
    }
}
```

Esta estrategia es útil si, de acuerdo con el principio de encapsulación
y ocultación de la información, deseamos declarar un campo de una clase
como privado, pero queremos poder modificar su valor desde el editor del
mismo modo que si fuera público. La regla general es que si es un tipo
es serializable, se mostrará.

> También es posible mostrar datos vía el _Inspector_ mediante
> funcionalidades más avanzadas como un _script_ de editor.

## No persistencia de estado entre modo edición y ejecución

Es importante tener en cuenta que, al salir del modo ejecución, se
pierden todas las modificaciones que se hayan hecho durante ese tiempo.
Por ejemplo, si antes de pulsar el botón _Play, testInt_ tenía como
valor 3, durante la ejecución lo modificamos para que tenga como valor 4
y salimos del modo ejecución, veremos que _testInt_ volverá a tener
valor 3.

--> <a href="Parte3-4.md">Página siguiente</a>

<br /><hr />
