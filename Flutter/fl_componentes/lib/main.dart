import 'package:fl_componentes/screens/listview1_screen.dart';
import 'package:fl_componentes/screens/listview2_screen.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      home: Listview2Screen(),
    );
  }
}