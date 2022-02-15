## 2.6. _Prefabs_

Es muy habitual durante el desarrollo de un proyecto tener estructuras
que se repiten a menudo. Por ejemplo, los enemigos se suelen controlar
por medio de uno o varios _scripts_ y, si tenemos cientos de ellos en
una pantalla, hay que añadírselos a todos uno a uno. Huelga decir que
añadir todos los _scripts_ con todas las configuraciones para cada uno
puede ser terriblemente tedioso; además, es muy probable que nos
equivoquemos en algún momento. Incluso podría ser peor si en un momento
más avanzado del desarrollo decidimos hacer algún cambio y tenemos que
repetir el proceso de nuevo: deberíamos asegurarnos de que modificamos
absolutamente todos los enemigos. Para evitar este tipo de problemas,
Unity tiene un sistema llamado **_prefab_**.

> Podemos imaginarnos un **_prefab_** como una plantilla donde guardamos
> el estado actual de un objeto y sus componentes. Esta plantilla se
> puede usar para instanciar objetos sin límite en cualquier escena del
> proyecto. Cualquier cambio hecho al _prefab_ original afecta a todas
> sus instancias.

No estamos obligados a que todos los objetos sean copias exactas. Una
vez se ha creado un objeto a partir del _prefab_, podemos personalizar
cada instancia individualmente si lo deseamos. Por ejemplo, para el caso
anterior, podríamos hacer que la mayoría de enemigos tengan la misma
velocidad, pero que uno en concreto sea más rápido, aun cuando comparta
el resto de propiedades exactamente.

Existen diversas maneras de crear un _prefab_, pero una relativamente
simple es la siguiente:

- Crear el GameObject que deseamos convertir en _prefab_ en el
  editor. Asignar todas las propiedades deseadas hasta tenerlo a
  punto.

- Arrastrar dicho objeto desde el apartado de Hierarchy al de
  Project.

- Al hacerlo, veremos que aparece un nuevo _asset_ con el nombre
  remarcado en color azul (en vez de negro, que es el habitual). Esto
  indica que se trata de un _prefab_.

- Para crear una instancia, basta con arrastrar el _prefab_ desde
  Project hasta Hierarchy, o bien directamente sobre la escena
  actual.

Para modificar las propiedades de todas las instancias a la vez, basta
con seleccionar el _prefab_ y editar los valores apropiados en la
pestaña Inspector.

> Es recomendable guardar todos los _prefabs_ de nuestro proyecto en la
> carpeta Prefabs.

--> <a href="Parte3.md">Página siguiente</a>

<br /><hr />
