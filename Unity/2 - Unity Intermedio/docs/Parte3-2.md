
# 3.2. La escena

Hay multitud de recursos en línea para crear terrenos 2D. En este caso,
lo que nos interesa es que podamos crear fácilmente desniveles que le
añadan dificultad al terreno y que los bloques se puedan agregar
contiguamente sin que se vean discontinuidades (lo que se conoce como
***tiles***). Elegiremos un fichero que contenga una cantidad de
*sprites* considerable, con la que podamos hacer terrenos bastante
variados. Aunque podríamos usar los *sprites* uno a uno, por separado,
trabajar con un *sprite* compuesto es más eficiente y más cómodo si
tenemos que cambiar algún parámetro a la hora de importar. El *sprite*
*atlas* llamado *tileset Tiles\_64x64* disponible
[aquí](https://opengameart.org/content/platform-tileset-nature) cumple
con todos estos requerimientos.

| **Reto 2** |
| ---    |
| Importad correctamente el sprite atlas, de modo que se pueda acceder de manera individual a cada una de las imágenes que lo componen. Para saber el tamaño de cada imagen individual, podéis consultar los datos proporcionados por el autor en Open Game Art. |

Otro parámetro que debemos tener en cuenta es el tamaño que ocupa en
pantalla cada *tile*, o "porción", del *sprite* múltiple. Para ello,
podemos añadir un *tile* a la escena, cerca del motorista, y jugar
cambiando el valor de Pixels Per Unit dentro de las opciones de
importación del *sprite* múltiple:

![](images/part3/tile_import_settings.png)

Para nuestro proyecto, un valor adecuado puede ser 32, ya que con este
valor cada *tile* es de aproximadamente el mismo tamaño que nuestro
motorista, al que hemos importado con un valor de Pixels Per Unit igual
a 100.

Al añadir un *tile* que se corresponda con el suelo del nivel, será
necesario añadirle el componente BoxCollider2D. Unity ajusta el tamaño
del BoxCollider2D para que coincida con el tamaño de la imagen
automáticamente. Podemos situar algunos *tiles* debajo del motorista,
pulsar Play y ver cómo este se estabiliza:


![](images/part3/tile_collider.png)

Antes de hacer un diseño completo del nivel, vamos a darle
comportamiento al motorista y a comprobar que su velocidad es adecuada
para los obstáculos que le queremos poner, entre otros aspectos.




