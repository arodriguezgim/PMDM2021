
# 2.1. El componente Rigidbody2D

Si bien Unity dispone de motor de físicas, ello no implica que estas se
apliquen automáticamente a todos los elementos de una escena.

> Un Rigidbody2D es un componente que le indica a Unity que debe
> aplicar físicas 2D al objeto que lo contiene.

Por lo tanto, todos los objetos que queramos que tengan un
comportamiento físico deberán contener este componente. Los que no lo
contengan ignorarán todos los aspectos relacionados con las físicas. Por
ejemplo, no se verán afectados por la fuerza de la gravedad.

Este componente tiene varios parámetros, pero varios de los valores por
defecto servirán para la mayoría de las ocasiones.

![](images/part2/rigidbody2d.png)

Los valores que normalmente modificaremos son los siguientes:

-   **Gravity Scale:** permite modificar la aceleración de la gravedad
    que afecta al GameObject. Esto nos puede ser útil para emular
    objetos que caen con un paracaídas, por ejemplo, o bien para objetos
    que queramos que estén suspendidos en el aire (para lo que usaríamos
    un valor igual a 0).

-   **Constraints:** sirven para fijar el GameObject, ya sea en
    posición o en rotación. Por ejemplo, podemos simular que un
    GameObject está clavado a una pared y que, por lo tanto, solo puede
    rotar si lo empujamos (aquí activaríamos Freeze Position X y Freeze
    Position Y), o bien podemos simular una plataforma dentro de un tubo
    que solo se puede desplazar en vertical (aquí activaríamos Freeze
    Position X y Freeze Rotation Z).

-   ***Body Type - Kinematic:** es necesario activarlo para controlar el
    movimiento del GameObject por script o con una animación. Esto es
    muy típico de los* juegos de plataformas, donde muchas plataformas
    tienen movimientos predefinidos y son el resto de objetos los que
    calculan sus físicas basándose en su movimiento.









