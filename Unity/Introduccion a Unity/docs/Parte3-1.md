# 3.1. Flujo de ejecución

En la mayoría de los motores modernos, el flujo de ejecución es muy
similar. Esto se debe a que la estructura de ejecución de cualquier
juego es esencialmente idéntica a la del resto. Un videojuego es,
generalmente, una aplicación altamente interactiva, con muchos elementos
que deben actuar de manera independiente en modo concurrente.
Básicamente, un juego se compone de un tiempo de inicialización (la
carga inicial del mismo) seguido por un bucle principal en el que, por
cada iteración del mismo, se genera una imagen o **_frame_** que
describe el estado del juego en ese momento. Durante cada _frame_, cada
objeto puede ejecutar código que actualice su estado.

> Cada iteración del bucle principal de juego se corresponde con una
> imagen estática (**_frame_**) generada como resultado.

Dependiendo del tipo de juego, el bucle principal puede requerir de una
respuesta más o menos inmediata. Por ejemplo, no es lo mismo un FPS que
un juego de cartas.

> Si deseamos 60 FPS en nuestro juego, hemos de garantizar que toda la
> lógica del mismo se ejecute en no más de 16 milisegundos por _frame_.

Es importante tener en cuenta que los _scripts_ en sí mismos, como
_assets_ dentro de nuestro proyecto, no se ejecutarán a menos que se
asignen como componente a algún GameObject en la escena del juego.
Unity solo ejecuta los métodos de scripts asociados a un GameObject de
la escena en curso. Esto lo debemos hacer desde el editor, seleccionando
un GameObject en la pestaña Scene. Entonces, desde el Inspector debemos
pulsar el botón Add Component y seleccionar un script de C\#.

--> <a href="Parte3-2.md">Página siguiente</a>

<br /><hr />
