
# 2.2. El componente Collider2D


En realidad, un Collider2D es un concepto genérico del que existen
varios tipos.

> Un Collider2D define un área que el motor de físicas 2D de Unity
> controla para detectar colisiones. Tenemos que asegurarnos de que el
> Collider que escogemos sea 2D, porque, si bien podemos tener un
> proyecto que use físicas 2D y 3D a la vez, ambas funcionan con motores
> independientes y sin interacción entre sí.

La razón de que existan varios tipos distintos es la optimización. Los
cálculos físicos pueden ser costosos en recursos, por lo que hay que
hacer lo posible para evitar cálculos innecesarios. Existen fórmulas
matemáticas para cierto tipo de formas que facilitan enormemente el
proceso de cálculo, como por ejemplo los círculos o los rectángulos. De
esta manera, siempre que queramos trabajar con objetos que tengan formas
parecidas a las de los Collider2D disponibles, los usaremos.

> BoxCollider2D es un tipo de Collider2D para formas rectangulares.

En caso de tener un objeto muy específico que no se pueda adaptar a los
Collider2D sencillos, existen algunas alternativas. Por ejemplo, podemos
usar el PolygonCollider2D, que permite editar la forma a nuestro gusto.
Al añadirlo a un GameObject, en el Inspector podemos ver un botón Edit
Collider que permite añadir vértices en el área de colisión mediante la
ventana Scene, tal y como muestra la siguiente figura:

![](images/part2/polygoncollider2d.png)
Un parámetro que tienen todos los Collider2D es Is Trigger. Cuando este
parámetro está activado, le indica al motor de físicas que no queremos
que se encargue de reaccionar de forma realista a las colisiones, sino
que simplemente queremos detectar mediante un evento especial que esta
ha sucedido, de modo que nosotros la gestionaremos mediante un *script*.
Por ejemplo, puede ser muy útil poner un GameObject vacío en un sitio
específico de nuestra escena con un Collider2D para detectar que
nuestro personaje ha llegado allí, como puede ser el final de una
pantalla, de cara a poder cargar otra pantalla nueva.

> Dos objetos que chocan sin Is Trigger activado pueden salir despedidos
> entre sí, por ejemplo.

Así pues, Unity diferencia entre un componente que gestiona el
movimiento de objetos según las leyes de la física (Rigidbody2D) y otro
que gestiona las colisiones (Collider2D). Sin embargo, hay que aclarar
que cuando tenemos dos GameObjects y queremos controlar las colisiones
entre ellos, es imprescindible que al menos uno tenga un Rigidbody2D. Si
además queremos que reaccionen de manera realista, tenemos que
asegurarnos de que ninguno de los dos Collider2D tenga marcada la opción
Is Trigger o, de no ser así, solo recibiremos un aviso de que se ha
producido la colisión.

También es importante tener claro que, a pesar de que podemos mover los
GameObjects en el eje Z (recordemos que, internamente, Unity trabaja en
3D), los cálculos de las físicas 2D ignoran esta dimensión. En este
sentido, hay que imaginar que es como si todos los GameObjects
estuvieran situados en Z = 0.
