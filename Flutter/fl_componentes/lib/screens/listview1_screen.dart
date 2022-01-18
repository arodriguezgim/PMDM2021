import 'package:flutter/material.dart';

class Listview1Screen extends StatelessWidget {

  final opciones = ['Ferrari','Audi','Seat Panda','Mercedes Benz','Ford'];

  Listview1Screen({Key? key}) : super(key: key);
 
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text('Lista de elementos'),
        elevation: 0,
      ),
      body: ListView(
        children: [
          //El operador spread extrae cada uno de los elementos
          //y devuelve un nuevo elemento
          ...opciones.map(
            (marca) => ListTile(
                  title: Text(marca),
                  leading: const Icon( Icons.access_time_sharp ),
                  trailing: const Icon( Icons.arrow_forward_ios_outlined ),
                  onTap: (){
                    print('Hola Carlos');
                  },
                )
            )
            
          
        ],
      )
    );
  }
}