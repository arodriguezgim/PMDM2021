# 4.1. Flujo del juego

Antes de empezar a desarrollar el proyecto propiamente dicho, vamos a
analizar cuál será el flujo del juego para así tener claro qué
herramientas necesitaremos.

La idea es crear un nivel de nuestro juego, pero diseñando nuestro
proyecto de manera que se pueda expandir fácilmente en un futuro. Muchos
juegos que tienen distintos niveles suelen tener una pantalla principal
en la que le preguntan al jugador si quiere ir a un nivel u otro, o si
quiere cargar una partida anterior. Como vamos a tener un solo nivel,
una pantalla de este tipo no es estrictamente necesaria, pero puede ser
muy útil incluirla para luego poder expandir el juego a más niveles.

> Al crear un juego, se recomienda empezar por la generación del
> recorrido básico entre escenas (pantalla de inicio, de juego, de final
> de partida, de configuración, etc.).

Esta pantalla de inicio de momento solo necesita contener un par de
botones, uno para llevarnos a la partida y otro para salir del juego. La
pantalla de la partida contendrá básicamente elementos de UI, ya que es
una aventura de texto. Cuando el jugador acabe esta pantalla, debemos
enseñarle algún mensaje para que quede claro que ha progresado en el
juego o, en este caso, que lo ha terminado. Si tuviésemos más niveles,
podríamos añadir opciones de guardar la partida o de saltar a otro
nivel. En cambio, con solo un nivel de juego, este mensaje puede parecer
irrelevante. Sin embargo, por el mismo motivo que hemos mencionado
anteriormente, es mejor añadir este elemento para poder ampliar el juego
más adelante.

De esta manera, vemos que necesitaremos tres partes, la pantalla
inicial, la pantalla del juego y la pantalla de final. Vamos a explicar
las herramientas fundamentales para desarrollar todas ellas, empezando
por el UI.

--> <a href="Parte4-2.md">Página siguiente</a>

<br /><hr />
