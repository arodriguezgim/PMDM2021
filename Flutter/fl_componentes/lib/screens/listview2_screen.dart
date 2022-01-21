import 'package:fl_componentes/screens/home_screen.dart';
import 'package:flutter/material.dart';

class Listview2Screen extends StatelessWidget {

  final opciones = ['Ferrari','Audi','Seat Panda','Mercedes Benz','Ford'];

 
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.indigo,
        centerTitle: true,
        title: const Text('Lista de elementos 2'),
        elevation: 0,
      ),
      body: ListView.separated(

        itemBuilder: (context, index) { 
           return ListTile(
            title: Text(opciones[index]),
            trailing: const Icon( Icons.arrow_forward_outlined),
            onTap: (){
              // Navegación en Flutter
              //final iraHome = MaterialPageRoute(
              //  builder: ( context ) => HomeScreen()
              //  );
              //Navigator.push(context, iraHome);
              Navigator.pushNamed(context, 'home');
              // Navigator.pushReplacementNamed(context, 'home');
            },
          );
        }, 
        //Me esta pidiendo el Widget que quiere que use como separador
        separatorBuilder: ( _ , __ ) => const Divider(), 
        // Numero de elementos. Los elementos NO se renderian de manera instantánea
        itemCount: opciones.length
        )
    );
  }
}
