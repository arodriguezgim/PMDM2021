import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  final tamano30 = const TextStyle(fontSize: 30);

  int contador = 15;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Contador DAM'),
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
        floatingActionButton: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            FloatingActionButton(
              child: const Icon(Icons.remove),
              onPressed: (){
                contador--;
                //Le tengo que avisar de que ha habido cambios en mi UI
                setState(() {});
              },
            ),
            // SizedBox(width: 10,),
            FloatingActionButton(
              child: const Icon(Icons.restore),
              onPressed: (){
                contador=0;
                //Le tengo que avisar de que ha habido cambios en mi UI
                setState(() {});
              },
            ),
            FloatingActionButton(
              child: const Icon(Icons.add),
              onPressed: (){
                contador++;
                //Le tengo que avisar de que ha habido cambios en mi UI
                setState(() {});
              },
            ),
          ],
        ),
        //floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      );
  }
}