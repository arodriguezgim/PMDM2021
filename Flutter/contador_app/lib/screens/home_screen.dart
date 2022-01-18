import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {

  final tamano30 = const TextStyle(fontSize: 30);
  int contador = 15;
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('App Contador'),
        elevation: 0,
      ),
      backgroundColor: Colors.white,
      body: Center(
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children:[
              Text('Número de Taps:', style: tamano30 ),
              Text('$contador', style: tamano30 ),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: const Icon(Icons.add),
          onPressed: (){
            contador++;
            
            print(contador);
           // print('Hola DAM 2');
          },
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      );
  }
}