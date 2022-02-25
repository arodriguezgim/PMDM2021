
# 3.4. Diseño de un nivel


Una de las claves a la hora de diseñar un buen nivel se encuentra en el
equilibrio de la dificultad. Un nivel demasiado difícil puede ser
frustrante, pero si es demasiado fácil puede que no resulte un desafío
interesante. En este caso, hemos diseñado nuestro nivel de la siguiente
manera:

![](images/part3/level.png)


El objetivo del jugador en este nivel es llegar hasta la parte derecha,
donde se encuentra el diamante rosa. Hay varias cuestiones que debemos
tener en cuenta para que un nivel esté completo y sea correcto. La
primera, que debe ser posible acabarlo y que debe tener comportamientos
coherentes. Por ejemplo, debemos asegurarnos de que cada *tile* en donde
se puede apoyar el motorista tiene un *collider* añadido. Si no fuera
así, el motorista caería al vacío y el jugador lo percibiría como
incorrecto. Podemos hacer una comprobación rápida seleccionando todo el
terreno para poder ver en el editor todos los *colliders* en verde. Para
los *tiles* que no son cuadrados hemos usado PolygonCollider2D, y Unity
ha ajustado automáticamente la forma.

![](images/part3/level_colliders.png)

En segundo lugar, el motorista debe poder ser controlable y también
capaz de llegar hasta el final. Si dejamos la configuración tal como
estaba hasta ahora, no será capaz de subir cuestas. Haciendo algunas
pruebas, podemos ver que una velocidad adecuada (parámetro
LinearVelocity del motorista) es 10.

Un tercer aspecto es que hay que ofrecer un aliciente de gamificación,
es decir, un sistema de recompensas y de desafíos para el jugador,
además de un principio y un final. Vamos a ver cómo hacerlo de manera
simple.

El jugador tiene que ser consciente de cuándo empieza y cuándo acaba el
juego, y también de cuándo lo acaba con éxito o no. Hemos dicho que el
objetivo del jugador es llegar al diamante rosa, y un desafío simple que
podemos ofrecer es el tiempo que tarda en lograrlo. También tenemos que
hacer algo cuando el motorista se da la vuelta, además de controlar el
movimiento de la cámara. Vamos a empezar por detectar cuándo llega al
diamante, cuándo se da la vuelta y cuándo se cae al vacío.

Primero tenemos que poder distinguir entre si lo que está tocando el
motorista es el diamante o cualquier otra cosa. Lo podemos hacer
mediante una herramienta muy útil de Unity, que son los *tags*. Por
ejemplo, podemos asignar el *tag* Finish al diamante y luego detectar
la colisión con el diamante leyendo el *tag* del objeto colisionado.

![](images/part3/end_of_level_tag.png)

> Un ***tag*** es simplemente una etiqueta, que podemos leer dentro de
> un *script* para realizar una acción u otra.

| **Reto 3** |
| ---    |
| Adaptad el código de BikeController para saber cuándo hemos tocado el diamante rosa. Cread un nuevo delegado llamado OnKilled que se llame solo cuando la moto toque el diamante rosa, leyendo el *tag* del objeto colisionado. |

Para conseguirlo, hay que utilizar el *tag* para identificar qué objeto
entra en colisión con el motorista en el método OnTriggerEnter2D.

| **Reto 4** |
| ---    |
|Cread un *script* que reinicie el nivel cuando la moto haya colisionado con un objeto que no sea el diamante, como, por ejemplo, cuando la moto se da la vuelta. Usad el delegado implementado en el reto anterior. |

En este caso, tenemos que aprovechar el delegado OnKilled. Sabemos que
para suscribir el evento tenemos que añadir una función a OnKilled y que
esta función será llamada automáticamente cuando ocurra el evento de
muerte. Por lo que solo hace falta hacer una nueva clase con un método
para reiniciar la escena. Lo habitual es hacer un *script*
GameplayManager, en el que ponemos todos estos métodos relacionados con
el funcionamiento del juego.

| **Reto 5** |
| ---    |
| Completad la escena de manera que, sin modificar *scripts*, también detecte que la moto se ha salido de la pantalla. Añadid objetos vacíos, solo con *colliders*, para utilizar el sistema de detección de colisiones de Unity.|

> En Unity se usan mucho los objetos vacíos. Por ejemplo, para ejecutar
> un *script*, detectar algo, activar un evento, etc.

Cuando detectamos que el motorista colisiona con uno de estos objetos
vacíos, ya ha fallado y reiniciamos el *level*. También debemos tener en
cuenta que si el motorista se mueve, pero la cámara no, lo perderemos de
vista. Con un simple *script* podemos arreglar este problema.

| **Reto 6** |
| ---    |
| Cread un *script* que mueva la cámara siguiendo a la moto, siempre desde la misma distancia. |

> En Unity, cada objeto en una escena tiene un Transform. Se utiliza
> para almacenar y manipular la posición, la rotación y la escala del
> objeto. Cada Transform puede tener un padre, lo que le permite
> aplicar la posición, la rotación y la escala jerárquicamente.

Para lograrlo, hay que añadir una distancia fija a la posición actual
del motorista para obtener la posición de la cámara. Esto también se
debería añadir al *script* GameplayManager.

