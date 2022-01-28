import 'dart:io';
import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
   
  const AlertScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Alertas'),
      ),
      body: Center(
        child: ElevatedButton(
          //Mostraremos la alerta DEPENDIENDO DONDE SE EJECUTA LA APP
          onPressed: () => Platform.isAndroid 
              ? mostrarAlertaAndroid(context)
              : mostrarAlertaIOS(context),
          child: const Padding(
            padding: EdgeInsets.symmetric(vertical: 15, horizontal: 20),
            child: Text('Mostrar Alerta', style: TextStyle( fontSize: 20),),
          ),
          ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          Navigator.pop(context);
        },
        child: const Icon( Icons.close),
        ),
    );
  }

  void mostrarAlertaAndroid(BuildContext context) {
    showDialog(
      barrierDismissible: false,
      context: context, 
      builder: ( context ){
        return AlertDialog(
          elevation: 5,
          shape: RoundedRectangleBorder(borderRadius: BorderRadiusDirectional.circular(10)),
          title: const Text('Titulo'),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: const [
              Text('Este es el contenido de la columna'),
              SizedBox(height: 20,),
              FlutterLogo( size: 100,)
            ],
          ),
          actions: [
            TextButton(
              onPressed: (){
                Navigator.pop(context);
              }, 
              child: const Text('Cancelar', style: TextStyle(color: Colors.red),),
              ),
            TextButton(
              onPressed: (){
                Navigator.pop(context);
              }, 
              child: const Text('Ok'),
              ),
          ],
        );
      },
      );
  }

  void mostrarAlertaIOS(BuildContext context) {
    showCupertinoDialog(
      barrierDismissible: true,
      context: context, 
      // Este builder me está pidiendo que construya el Widget de la Alerta
      builder: ( context ){
        return CupertinoAlertDialog(
          title: const Text('Soy un título'),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: const [
              Text('Este es el contenido de la columna'),
              SizedBox(height: 20,),
              FlutterLogo( size: 100,)
            ],
          ),
          actions: [
            TextButton(
              onPressed: (){
                Navigator.pop(context);
              }, 
              child: const Text('Cancelar', style: TextStyle(color: Colors.red),),
              ),
            TextButton(
              onPressed: (){
                Navigator.pop(context);
              }, 
              child: const Text('Ok'),
              ),
          ],
        );
      },
      );
  }
}