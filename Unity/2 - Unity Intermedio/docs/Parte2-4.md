

# 2.4. Ajustes de las físicas


Hay proyectos que pueden requerir opciones un poco más específicas, o
puede que detectemos que las físicas están ralentizando nuestro proyecto
y queramos intentar optimizarlas. En estos casos, podemos ir al menú
Edit \> Project Settings \> Physics 2D. Al hacer clic nos saldrán las
siguientes opciones ajustables:

![](images/part2/layer_collision_matrix.png)


En la mayoría de los casos, los valores por defecto nos servirán para
casi cualquier proyecto. Sin embargo, hay opciones que probablemente
queramos ajustar. Por ejemplo, cambiar el parámetro *Gravity* nos
permite simular juegos en el espacio con muy baja gravedad, o simular el
balanceo de un barco.

En la parte inferior se encuentra la matriz de capas de colisión, que
indica las relaciones entre grupos de objetos que pueden colisionar con
otros. Por ejemplo, si tenemos un juego de plataformas, no querremos que
el fondo colisione ni con las plataformas ni con los personajes. Con
esta matriz podemos seleccionar qué capas colisionan con otras. De esta
manera, podemos evitar que el motor de física haga cálculos innecesarios
y, por lo tanto, conseguiremos aligerar nuestra aplicación.

> La matriz de colisión se basa en los tipos de *layer*, no de *sorting*
> *layer*.
