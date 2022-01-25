import 'package:fl_componentes/widgets/widgets.dart';
import 'package:flutter/material.dart';

class CardScreen extends StatelessWidget {
   
  const CardScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    
    return Scaffold(
      appBar: AppBar(
          title: const Text('Tarjetas Widget'),
      ),
      body: ListView(
        padding: const EdgeInsets.symmetric(vertical: 20,horizontal: 10),
        children: [
          
          const TarjetaTipo1(),
          const SizedBox(height: 5,),
          TarjetaTipo2(urlImagen: 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg', texto: 'Un precioso paisaje',),
          const SizedBox(height: 5,),
          TarjetaTipo2(urlImagen: 'https://cdn.pixabay.com/photo/2016/08/09/21/54/lake-1581879_960_720.jpg',),
          const SizedBox(height: 5,),
          TarjetaTipo2(urlImagen: 'https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_960_720.jpg', texto: 'Hola Soy Alberto',),
        ],
      )
    );
  }
}

