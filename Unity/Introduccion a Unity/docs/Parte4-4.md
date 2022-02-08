# 4.4. La pantalla de fin de juego

Hay varias opciones para comunicarle al jugador que el juego ha
terminado. Diferentes juegos nos han demostrado que puede haber una gran
diversidad en este aspecto, desde dejarnos rebobinar en el tiempo hasta
pantallas específicas relacionadas con la muerte. Sin embargo, la
mayoría de los juegos optan por una solución más sencilla y menos
creativa, aunque conocida por cualquier jugador con un mínimo de
experiencia. Esta solución consiste en mostrar un mensaje que le indica
al jugador que la partida se ha acabado y le muestra varias opciones,
que pueden abarcar desde repetir el nivel hasta volver al menú
principal.

En nuestro caso, ya que tenemos una pantalla inicial, podemos mostrar un
simple mensaje y dar la opción de reiniciar la partida o de volver a la
pantalla principal. Vamos a crear una UI sencilla, con dos botones, como
podéis ver en la figura siguiente. El botón de la izquierda queremos que
nos lleve a la pantalla inicial, mientras que el botón de la derecha
reinicia directamente la partida.

![](images/part4/pause.png)

| **Reto 9**                                                                                                                                     |
| ---------------------------------------------------------------------------------------------------------------------------------------------- |
| Cread esta pantalla, de manera similar a cuando elaborasteis la pantalla de inicio, y haced que GameplayManager la muestre al acabar el juego. |

Aprovechando que tenemos una pantalla que permite volver al menú de
inicio o reiniciar una partida, podemos incluir una funcionalidad de
pausa en el juego, de manera que cuando se pulsa la tecla _Esc_,
aparezca esta pantalla. Así, en cualquier momento podemos salir de la
partida de manera limpia.

| **Reto 10**                                               |
| --------------------------------------------------------- |
| Añadid la opción de cancelar la partida con la tecla Esc. |

Ahora, tan solo tenemos que asociar los eventos OnClick, el del botón
MainMenuButton al método LoadMainMenu, y el del botón RestartGameButton
a RestartGame. También tenemos que añadir una variable pública de tipo
GameObject en el _script_ GameplayManager, que asociaremos en el editor
a la UI que acabamos de crear. Finalmente, esta UI la debemos posicionar
en el centro de la pantalla y desactivarla, para que el jugador la vea
cuando se activa, pero que esté invisible por defecto.

Como detalle, podemos observar que esta UI es perfectamente válida para
cuando pausamos el juego. De esta manera, hemos escogido la tecla Esc
para enseñarla, como se puede ver en el método Update.

--> <a href="Parte4-5.md">Página siguiente</a>

<br /><hr />
