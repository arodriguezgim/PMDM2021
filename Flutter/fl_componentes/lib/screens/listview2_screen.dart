import 'package:flutter/material.dart';

class ListviewScreen extends StatelessWidget {

  final opciones = ['Ferrari','Audi','Seat Panda','Mercedes Benz','Ford'];

 
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text('Lista de elementos 2'),
        elevation: 0,
      ),
      body: ListView.separated(

        itemBuilder: (context, index) { 
          ListTile(
            title: Text(opciones[index]),
            trailing: const Icon( Icons.arrow_forward_outlined),
            onTap: (){},
          );
        }, 
        //Me esta pidiendo el Widget que quiere que use como separador
        separatorBuilder: (), 
        // Numero de elementos. Los elementos NO se renderian de manera instantánea
        itemCount: opciones.length
        )
    );
  }
}