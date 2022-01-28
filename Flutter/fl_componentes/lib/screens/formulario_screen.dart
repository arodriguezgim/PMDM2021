import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
   
  const FormularioScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Formulario'),),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          child: Column(
            children: [
              TextFormField(
                autofocus: true,
                textCapitalization: TextCapitalization.words,
                onChanged: ( valor ) => print('Valor: $valor'),
                validator: ( valor ){
                  if ( valor == '' ) return 'Este campo es requerido';

                },
                autovalidateMode: AutovalidateMode.onUserInteraction,
              )
            ],
          ),
        ),
      )
    );
  }
}