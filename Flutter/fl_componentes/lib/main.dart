import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'screens/screens.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      // home: HomeScreen(),
      theme: AppTheme.lightTheme,
      initialRoute: 'home',
      routes: {
        'home'         : ( BuildContext context ) => HomeScreen(),
        'lista1'       : ( BuildContext context ) => Listview1Screen(),
        'lista2'       : ( BuildContext context ) => Listview2Screen(),
        'alerta'       : ( BuildContext context ) => AlertScreen(),
        'card'         : ( BuildContext context ) => CardScreen(),
        'formulario'   : ( BuildContext context ) => FormularioScreen(),
      },
    );
  }
}