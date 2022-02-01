import 'package:convex_bottom_bar/convex_bottom_bar.dart';
import 'package:flutter/material.dart';

class EjemploScreen extends StatelessWidget {
   
  const EjemploScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
  bottomNavigationBar: ConvexAppBar(
    items: const [
      TabItem(icon: Icons.home, title: 'Inicio'),
      TabItem(icon: Icons.map, title: 'Discovery'),
      TabItem(icon: Icons.add, title: 'Add'),
      TabItem(icon: Icons.message, title: 'Message'),
      TabItem(icon: Icons.people, title: 'Profile'),
    ],
    initialActiveIndex: 2,//optional, default as 0
    onTap: (int i) => print('click index=$i'),
    style: TabStyle.flip,
    backgroundColor: Colors.orange,
  )
);
  }
}