## 2.4. Unity en 2D frente a 3D

Unity empezó como un motor puramente 3D, sin soporte directo para juegos
2D. Sin embargo, varios desarrolladores añadieron posteriormente
funcionalidades 2D mediante _plug-ins_ externos, lo cual aumentó
enormemente la popularidad de Unity en el mundo de las aplicaciones para
móvil. A partir de la versión 4.3, Unity empezó a integrar una gran
cantidad de herramientas específicas para 2D en el motor. Sin embargo,
internamente Unity no distingue entre aplicaciones 2D y 3D. Las
diferencias se limitan a cambios de perspectiva y de motor físico. En
ese sentido, podemos imaginarnos que un proyecto 2D funciona como un
teatro de marionetas, donde el eje Z se corresponde a la profundidad del
escenario. Desde el punto de vista del espectador, vemos un conjunto de
capas bidimensionales superpuestas.

> Según el tipo de proyecto, 2D o 3D, Unity usa el motor físico Box2D o
> PhysX.

Si queremos trabajar en un proyecto 3D, nuestra escena mostrará el mundo
con sus tres coordenadas:

![](images/part2/3d_editor.png)

Podemos cambiar la perspectiva entre 2D o 3D pulsando la tecla 2, o bien
activando/desactivando el botón 2D en la parte superior de la pestaña
Scene. En el modo 3D, la posición y la orientación del GameObject
seleccionado se muestran con un eje de coordenadas.

> Eje de coordenadas con las flechas roja, verde y azul, que representan
> los ejes X, Y y Z, respectivamente, en la esquina superior derecha de
> la pestaña Scene:

![](images/part2/coordinates.png)

Esta misma escena la podemos observar en modo 2D. Al hacerlo, nos
situamos en una perspectiva en la que desaparece el eje Z y vemos el
mundo siempre centrado en el eje Z.

![](images/part2/2d_editor.png)

Dado que realmente Unity está trabajando con 3D, podemos incluir objetos
situándolos simplemente unos delante de otros en el eje Z. En ese
sentido, cabe señalar que, aunque este módulo se centra en proyectos 2D,
casi todo lo que aprendamos será aplicable también a proyectos 3D.

--> <a href="Parte2-5.md">Página siguiente</a>

<br /><hr />
