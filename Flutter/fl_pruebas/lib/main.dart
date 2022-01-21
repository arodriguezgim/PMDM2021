import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      title: 'Cupertino App',
      home: CupertinoPageScaffold(
        navigationBar: const CupertinoNavigationBar(
          backgroundColor: Color(0xFF42A5F5),
          middle: Text('Cupertino App Bar'),
        ),
        backgroundColor: Color(0xFFFFFFFF),
        child: Center(
          child: Container(
            child: Text('Hola SMR'),
          ),
        ),
      ),
    );
  }
}