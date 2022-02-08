# 3. _Scripting_ en Unity

Si bien Unity permite gestionar el comportamiento de los GameObjects
hasta cierto punto por medio del editor, el caso más habitual será el de
programar la lógica de nuestro juego con fragmentos de código fuente,
llamados _scripts_.

> Un **_script_** en Unity es un componente más que podemos definir
> nosotros, siempre asociado a un GameObject concreto.

El lenguaje de programación que utiliza Unity es C\#. Los _scripts_ de
Unity son clases que heredan de la superclase MonoBehaviour, definida
por el propio motor, y que sirve como interfaz para poder implementar
varias funciones a las que se llama internamente desde Unity, mediante
su redefinición (_override_). Los métodos más importantes y que usaremos
más a menudo son los siguientes:

- **Awake** y **Start:** se invocan al iniciarse por primera vez el
  _script_, una sola vez.

- **OnEnable:** se invoca cuando se habilita el objeto.

- **OnDisable:** se invoca cuando se deshabilita el objeto.

- **OnDestroy:** se invoca cuando se destruye el objeto.

- **Update:** se invoca una vez por cada _frame_ de ejecución.

Si exploramos la documentación oficial de Unity, veremos que la lista es
en realidad mucho más amplia. Aunque podemos encontrar toda la
información en dicha documentación, en esta sección vamos a describir
brevemente cuándo se ejecuta cada método y su caso de uso más común,
además de las convenciones que vamos a utilizar a la hora de programar
en Unity.

> Podéis encontrar la documentación oficial de la clase MonoBehaviour
> [aquí](https://docs.unity3d.com/ScriptReference/MonoBehaviour.html).

Históricamente, Unity no ha seguido fielmente las convenciones estándar
de C\# establecidas originalmente por Microsoft. Sí lo está haciendo más
recientemente, así que en el curso también lo haremos. Los puntos
básicos de esta convención son los siguientes:

- Los nombres de clases y métodos son CamelCase.

- Los nombres de propiedades y variables públicas son CamelCase.

- Los nombres de variables privadas comienzan por minúscula.

- No se utilizan nunca prefijos del tipo CMiTipo o
  m_miVariablePrivada.

Un punto que hay que destacar es que Unity nos obliga a que los ficheros
de _script_ se llamen igual que la clase que contienen.

## Consideraciones sobre el _scripting_ en Unity

A los programadores más experimentados les puede sorprender el hecho de
que no haya que usar _keywords_ como _override_ o que las llamadas a
métodos como Start o Update puedan tener firmas distintas (pueden
ser públicos, privados, pueden retornar datos o no, etc.). El motivo de
que esto se pueda hacer es que el motor no hace llamadas directas a
estos métodos, sino que usa _reflection_. Esta flexibilidad tiene un
coste asociado en términos de rendimiento, ya que llamar a un método
mediante _reflection_ es más caro que hacer una llamada directa.

--> <a href="Parte3-1.md">Página siguiente</a>

<br /><hr />
