## 2.1. Estructura de un proyecto de Unity

Antes de comenzar a crear contenido propiamente dicho, vamos a examinar
cómo se estructura un proyecto de Unity. A nivel general, un proyecto
sigue una estructura jerárquica. Primero de todo, cada proyecto contiene
una o más **escenas** (**_scenes_**), que son la manera básica de
organizar nuestro juego. Una escena normalmente equivale a un nivel o
una pantalla en un juego. Por ejemplo, en un juego tipo Angry Birds
podríamos tener las siguientes escenas:

- Menú principal: donde escogemos dónde queremos jugar.
- Escena de juego: donde jugamos.

A su vez, cada escena es un conjunto de elementos, que Unity denomina
individualmente **GameObject**.

Un GameObject puede ser cualquier cosa de nuestro juego. Por ejemplo,
puede ser una luz, un _script_, una textura o un volumen para calcular
colisiones.

Los distintos objetos se distinguen entre sí según su comportamiento. Lo
que define el comportamiento de un objeto u otro son los **componentes** que contengan. Cada tipo de componente tiene un
efecto distinto. En este sentido, nos podemos imaginar un _GameObject_
como un contenedor de componentes. Sin embargo, existe un caso especial:
el de un GameObject vacío; este tipo de objeto no tiene una
representación visual en pantalla y normalmente se utiliza para
organizar la lógica del juego.

Veamos una ilustración de esta estructura:

![Estructura de un proyecto de Unity](images/part2/estructura_proyecto.png)

--> <a href="Parte2-2.md">Página siguiente</a>

<br /><hr />
