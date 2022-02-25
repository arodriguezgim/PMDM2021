
# 1.1. El editor de *sprites*


El editor de *sprites* es la herramienta que permite editar las
propiedades de los *sprites* en nuestro proyecto de Unity.

En nuestro proyecto de referencia, si seleccionamos Assets \> Sprites \>
\_Character \> char\_hero\_beanMan podemos visualizar la imagen
*beanMan*. En este caso, se trata de un *sprite* *atlas* que contiene
los gráficos que representan todas las partes del cuerpo de un
personaje.

En el Inspector podemos ver el modo en el que está importado, dentro
de la opción Texture Type. El modo que nos interesa es Sprite (2D and
UI). Dado que esta imagen es en realidad un atlas, debemos asegurarnos
de que el apartado Sprite Mode tiene puesto el valor Multiple.

![](images/part1/sprite_import_settings.png)


Unity intenta aproximar automáticamente la división del atlas en
*sprites* separados, pero no siempre nos dará el resultado que estamos
buscando. Para editar manualmente la imagen, pulsaremos el botón Sprite
Editor, de modo que aparecerá una nueva pestaña, el editor de
*sprites*.

Dentro de este editor podemos realizar varias acciones. Con el ratón,
podemos seleccionar las áreas ya creadas automáticamente por Unity
haciendo clic en los recuadros que se muestran. Esta acción causa que
los bordes del recuadro se muestren de color azul y que lo podamos mover
arrastrando el ratón. También podemos redimensionarlo estirando las
esquinas, o cambiar el pivote arrastrando el círculo azul. Normalmente,
el pivote está centrado en el *sprite*, pero es posible que nos interese
cambiarlo. Por ejemplo, el pivote de unos brazos estaría en el hombro,
ya que es desde donde en realidad rota.

> El pivote es el punto de apoyo desde el cual un objeto rota.

Una vez editado un *sprite* múltiple, podemos ver que en el apartado
Project nos aparece un desplegable con todos los *sprites*
individuales que hemos puesto en su interior. En nuestro caso,
char\_hero\_beanMan.

Si seleccionamos con el ratón cada *sprite* individual, lo podemos
previsualizar en el Inspector.

Con todos los recursos preparados, ya podemos empezar a trabajar con
ellos. En este caso, para combinarlos y crear un único personaje
complejo, el BeanMan. Para ello, vamos arrastrando cada *sprite*
individual a la escena, ya sea sobre el panel Hierarchy o directamente
sobre el panel Scene del editor. Una vez añadidos todos los elementos
y organizados visualmente, el resultado que tenemos puede ser algo
parecido a la imagen siguiente:

![](images/part1/no_sorting_layers.png)

Durante este proceso, un problema que se hace evidente es que hay
elementos que tapan a otros, con un orden de visualización que no es el
que estamos buscando.
