
# 2. Físicas 2D

Las físicas (velocidad de objetos, gravedad, colisiones, etc.) son una
de las herramientas más útiles para nuestro juego que nos aporta Unity.
En sus orígenes, Unity era un motor exclusivamente 3D, y no fue hasta la
versión 4.3 cuando incorporó un motor de físicas pensado para juegos 2D.
En esta sección, describiremos los componentes básicos para trabajar con
físicas 2D en Unity, aunque la mayoría de conceptos también son válidos
para las físicas 3D.

> Unity usa internamente el motor de físicas 2D de código libre
> [Box2D](http://box2d.org).

Lo primero que veremos es cómo detectar colisiones entre objetos. Para
ello, necesitaremos dos componentes distintos: un Collider2D y un
Rigidbody2D.
