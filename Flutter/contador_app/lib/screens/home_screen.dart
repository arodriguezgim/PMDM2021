import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('App Contador'),
        elevation: 0,
      ),
      backgroundColor: Colors.white,
      body: Column(
          children: const [
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
            Text('Hola a TODOS'),
          ],
        ),
      );
  }
}