# 3.5. Ciclo de vida y orden de ejecución de los MonoBehaviour

En los ejemplos que hemos ido viendo, hemos añadido los _scripts_ a un
único objeto, pero ¿qué pasaría si los añadiésemos a más objetos? La
respuesta es que cada objeto que tuviese el _script_ añadido se
comportaría de la misma manera y, por lo tanto, el mismo código se
ejecutaría varias veces, una por objeto. Pero ¿qué instancia se ejecuta
primero? ¿Y si tuviéramos varios _scripts_ distintos y quisiéramos que
un _script_ se ejecutase antes que otro? ¿Cómo podemos saber cuándo se
va a ejecutar un _script_?

Unity está diseñado con la simplicidad en mente. La filosofía de
programación es bastante diferente a la de programar otro tipo de
aplicaciones. Generalmente, no tenemos manera de saber el orden exacto
en que se ejecutarán nuestros _scripts_. Tampoco instanciamos clases con
nuestro código, sino que añadimos _scripts_ a GameObjects y es el
motor el que se encarga de instanciar dichos _scripts_. Si bien esto en
la práctica resulta muy conveniente, puede resultar extraño si tenemos
experiencia programando otro tipo de aplicaciones.

A la hora de establecer el orden de ejecución, el motor se encarga de
tomar todas las decisiones a nivel interno. Una manera de acostumbrarse
a esta mentalidad es imaginarnos que todos nuestros _scripts_ se
ejecutan realmente en paralelo, una vez por _frame_. En el diseño de
nuestra aplicación debemos plantearnos que la mayoría de _scripts_ deben
ser lo más simples posibles y realizar una única tarea concreta y
completamente autocontenida. Por ejemplo, un _script_ puede controlar
cómo se mueve un enemigo, y otro controlar el desplazamiento para
evaluar si está cansado. Aunque se podría hacer todo en un mismo
_script_, por el modo de trabajar de Unity es mejor tener los dos por
separado.

Sin embargo, hay casos en los que realmente necesitamos tener el control
de qué se ejecuta antes, o enviar información o llamadas de un _script_
a otro. En este caso podríamos echar mano de otros métodos:

- **Awake:** se ejecuta una sola vez, inmediatamente tras cargarse la
  instancia del _script_ y antes del Start.

- **LateUpdate:** se ejecuta una vez por _frame_, igual que el
  Update, pero solo una vez ya se han ejecutado todos los métodos
  Update de todos los objetos.

> _Awake_ se ejecuta incluso antes de que se haya creado completamente
> el propio GameObject asociado.

La secuencia completa de ejecución de los métodos de un _script_ en
Unity se puede encontrar en la documentación oficial, pero, a título
ilustrativo y para ver su complejidad real, la reproducimos a
continuación:

![](images/part3/monobehaviour_flowchart.svg)

> Este esquema y su explicación asociada se pueden encontrar
> [aquí](https://docs.unity3d.com/Manual/ExecutionOrder.html).

En este módulo nos limitaremos a gestionar ciclos de ejecución basados
en los métodos Awake, Start y Update.

--> <a href="Parte4.md">Página siguiente</a>

<br /><hr />
