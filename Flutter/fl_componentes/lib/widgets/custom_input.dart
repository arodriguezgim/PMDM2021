import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';


class CustomInputField extends StatelessWidget {

  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? icon;
  final IconData? suffixicon;
  final TextInputType? keyboardType;
  final bool obscureText;

  // Recibimos el nombre del input que va a modificar este valor
  final String formPropierty;
  // Propiedad que mantiene todos los valores e un formulario
  final Map<String,String> formValues;


  const CustomInputField({
    Key? key, 
    this.hintText, 
    this.labelText, 
    this.helperText, 
    this.icon, 
    this.suffixicon, 
    this.keyboardType, 
    this.obscureText = false, 
    required this.formPropierty, 
    required this.formValues,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      autofocus: false,
      obscureText: obscureText,
      keyboardType: keyboardType,
      textCapitalization: TextCapitalization.words,
      //onChanged sirve para capturar el valor que introducimos
      onChanged: ( valor ) => formValues[formPropierty] = valor,
      validator: ( valor ) {
        if ( valor == null ) return 'Este campo es requerido';
        return valor.length < 3 
        ? 'Mínimo de tres letras' 
        : null; 
      },
      // le decimos  cuádo ha de evaluar esto
      autovalidateMode: AutovalidateMode.onUserInteraction,
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
        helperText: helperText,
        // counterText: 'Quedan 3 letras',
        suffixIcon: Icon( suffixicon ),
        // prefixIcon: Icon ( Icons.accessible_forward ),
        icon: icon == null ? null : Icon (icon),
      ),
    );
  }
}