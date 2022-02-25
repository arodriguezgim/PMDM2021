

# 1. *Sprites*

Un ***sprite*** es el término con el que nos referimos a cualquier
imagen bidimensional utilizada en un videojuego, normalmente en
conjunción con otras imágenes/*sprites* para conformar una escena más
grande.

Si bien podríamos utilizar un *sprite* independiente para cada gráfico
de nuestro juego, una optimización muy habitual consiste en agrupar
varios *sprites* en un mismo fichero conocido como ***sprite* *atlas***.
Para la tarjeta gráfica, es más eficiente renderizar partes de una
textura grande que renderizar varias texturas independientes más
pequeñas una detrás de otra, por el mayor número de cambios de estado en
el hardware que implica la segunda opción.

Si no tenemos un artista dentro de nosotros, tanto en webs
especializadas como en la Asset Store de Unity podemos encontrar
multitud de recursos para explorar y utilizar en nuestro proyecto. De
cara a este módulo, vamos a utilizar el siguiente paquete [2D
Platformer](https://gitlab.com/uoc-prog-2d-2020-21/modulo-3/-/raw/master/2D%20Platformer%20Resources.unitypackage).
