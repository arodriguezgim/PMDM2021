import 'dart:ui';

import 'package:flutter/material.dart';

class AppTheme {

  static const Color primary = Colors.orange;

  static final ThemeData lightTheme = ThemeData.light().copyWith(
        primaryColor: primary,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
          elevation: 0,
          backgroundColor: primary,
        ),

        // Estilo de los TextButton
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(primary: primary)
        ),

        //FloatingActionButtons
        floatingActionButtonTheme: const FloatingActionButtonThemeData(
          backgroundColor: primary,
          elevation: 5
        ),

        // ElevatedButtons
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            primary: primary,
            elevation: 0,
            shape: const StadiumBorder( )
          )
        ),

        // Estilo de los inputs
        inputDecorationTheme: const InputDecorationTheme(
          floatingLabelStyle: TextStyle( color: primary ),
          border: OutlineInputBorder(
                    borderSide: BorderSide(color: primary),
                    borderRadius: BorderRadius.only( 
                      bottomLeft: Radius.circular(10),
                      topRight: Radius.circular(10),
                      )
                    ),
          enabledBorder: OutlineInputBorder(
                    borderSide: BorderSide(color: primary),
                    borderRadius: BorderRadius.only( 
                      bottomLeft: Radius.circular(10),
                      topRight: Radius.circular(10),
                      )
                    ),
          focusedBorder: OutlineInputBorder(
                    borderSide: BorderSide(color: primary),
                    borderRadius: BorderRadius.only( 
                      bottomLeft: Radius.circular(10),
                      topRight: Radius.circular(10),
                      )
                    )
        ),

        // Estilo de los iconos
        iconTheme: const IconThemeData(color: primary)

  );

  static final ThemeData oscuroTheme = ThemeData.dark().copyWith(
        primaryColor: primary,

        // Estilo del AppBar
        appBarTheme: const AppBarTheme(
          elevation: 0,
          backgroundColor: Colors.pink,
        ),
        scaffoldBackgroundColor: Colors.black

  );
}