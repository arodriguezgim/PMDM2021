# 4.6. Exportar a una plataforma

Cuando desarrollamos un proyecto dentro del editor no tenemos manera de
ejecutarlo sin iniciar el editor. Para poder hacerlo, tenemos que
generar un ejecutable para la plataforma que nos interese. Lo que
tenemos que hacer en este caso es ir al menú File \> Build Settings y en
la pantalla que nos aparece seleccionar la plataforma con la que
queremos trabajar. Esto lo hacemos seleccionando la opción que nos
interese en la lista de plataformas que hay en la parte inferior
izquierda.

> El proceso de creación del ejecutable en Unity se conoce como
> **_build_**.

![](images/part4/build_settings.png)

Una vez seleccionada la plataforma, hacemos clic en Switch Platform, si
no era ya la opción seleccionada. Hay que tener en cuenta que Unity hace
una gran cantidad de optimizaciones internas por cada _asset_ según la
plataforma. Por este motivo, cada vez que cambiemos de plataforma, Unity
lanzará un proceso que puede ser bastante lento. De hecho, cuanto más
complejo sea el proyecto, más tardará, por lo que si tenemos claro que
solo queremos exportar a una plataforma deberíamos seleccionar esa
plataforma cuanto antes. En caso de querer exportar a múltiples
plataformas, se aconseja dejar el proyecto lo más pulido y testeado
posible para una plataforma y luego realizar este proceso, para
minimizar cambios de plataformas, que como ya hemos dicho son procesos
lentos.

| **Reto 12**                                                                                                                      |
| -------------------------------------------------------------------------------------------------------------------------------- |
| Una vez comprobado que el proyecto funciona correctamente, cread el ejecutable de manera que se pueda probar desde un navegador. |
