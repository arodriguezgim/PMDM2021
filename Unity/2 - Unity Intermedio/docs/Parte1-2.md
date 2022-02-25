
# 1.2. *Sorting layers*


Para solucionar este problema, una opción es usar la distancia a la
cámara. Incluso cuando trabajamos en modo 2D, Unity internamente
almacena y procesa toda la información en 3D. De esta manera, si movemos
elementos en el eje Z, podremos decidir qué objetos tapan a otros
acercándolos o alejándolos de la cámara.

Otra opción más interesante sería definir directamente el orden de
visualización de los elementos gráficos.

> Los ***sorting layers*** indican a Unity el orden de renderización de
> los *sprites* de una escena.

La idea principal es que los distintos *sprites* en una escena se
organicen en grupos homogéneos de elementos similares. Por ejemplo,
muchos juegos tienen un fondo donde hay un paisaje, incluso compuesto
por diversos elementos, que lógicamente siempre estará por detrás de los
elementos principales, como los personajes o los enemigos de nuestro
juego. Conceptualmente, todos estos elementos decorativos conforman un
grupo. Para ello, los podemos asignar a un *sorting layer* específico, y
el resto de elementos de juego a otro. De esta manera, nos aseguramos de
que podemos controlar directamente qué elementos tapan a qué otros.

Para definir qué *sorting* *layers* se superponen a otros o crear nuevas
capas, podemos ir al menú Edit \> Project Settings \> Tags and Layers.
Al hacer clic en esa opción, en el Inspector nos aparecen tres
desplegables: Tags, Sorting Layers y Layers.

![](images/part1/sorting_layers_list.png)

En el desplegable Sorting Layers, podemos ver una lista con todas las
capas de nuestro proyecto. En este caso, tenemos las capas por defecto
creadas por Unity. El orden es muy importante, ya que debemos saber que
los *sorting layers* se pintan en orden de arriba a abajo. A medida que
esto sucede, unos elementos pueden tapar a otros. Por ejemplo, en la
configuración por defecto mostrada, los elementos que estén en la capa
Default podrían quedar tapados por los elementos de Background, que
a su vez podrían ser tapados por elementos de Character. Y así
sucesivamente. Podemos reordenar estas capas simplemente arrastrándolas
arriba y abajo con el ratón. Para añadir o eliminar nuestras propias
capas podemos usar los botones con los símbolos + y —, abajo a la
derecha.

> La asignación de la capa a la que pertenece un elemento gráfico se
> lleva a cabo a través del Inspector, modificando de la propiedad
> Sorting Layer de su componente SpriteRenderer.

También es posible establecer el orden dentro de una misma capa. Esto
nos puede servir, por ejemplo, si tenemos un fondo donde hay un paisaje
y unos edificios. En ese caso, muy probablemente querremos que los
edificios tapen el paisaje. Sin embargo, seguramente tiene sentido que
ambos elementos pertenezcan a la capa Background, ya que realmente los
dos tipos de elementos son parte de la decoración. Para ello, se puede
usar la propiedad Order in Layer del componente SpriteRenderer. Si
varios elementos dentro de un mismo sorting layer tienen el mismo valor
en Order in Layer, se decide aleatoriamente qué elementos se superponen*
a otros.

En este caso, el uso de la propiedad Order in Layer es lo que tiene más
sentido de cara a ordenar los distintos *sprites* que conforman el
personaje BeanMan. Podemos usar el valor -1 con el *sprite* Bazooka, y
el valor 1 para los ojos, las manos y el bigote.

![](images/part1/sorting_layers.png)

