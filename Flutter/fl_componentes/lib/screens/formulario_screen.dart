import 'package:fl_componentes/widgets/widgets.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {

  // Necesito usar las keys.
  // Las keys son usadas para mantener la referencia al Widget y voy
  // a asignar una key al form
  final GlobalKey<FormState> myFormKey = GlobalKey<FormState>();

  final Map<String, String> formvalues = {
    'nombre'  : 'Alberto',
    'apellidos': 'Rodriguez',
    'email'    : 'alberto@gmail.com',
    'password' : '123456' ,
    'rol'      : 'Admin' 
  };
   
  FormularioScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Formulario'),),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          child: Form(
            key: myFormKey,
            child: Column(
              children:  [
                CustomInputField(formPropierty: 'nombre', formValues: formvalues, hintText: 'Nombre de usuario', labelText: 'Nombre', helperText: 'Introduce el nombre'),
                const SizedBox(height: 20,),
                CustomInputField(formPropierty: 'apellidos', formValues: formvalues, hintText: 'Apellidos de usuario', labelText: 'Apellidos', helperText: 'Introduce un apellido',),
                const SizedBox(height: 20,),
                CustomInputField(formPropierty: 'email', formValues: formvalues, hintText: 'Correo', labelText: 'Correo', suffixicon: Icons.mail, keyboardType: TextInputType.emailAddress,),
                const SizedBox(height: 20,),
                CustomInputField(formPropierty: 'password', formValues: formvalues, labelText: 'Contraseña', hintText: 'Contraseña del usuario', obscureText: true,),
                const SizedBox(height: 20,),
                DropdownButtonFormField<String>(
                  value: 'Admin',
                  items: const [
                    DropdownMenuItem(value: 'Admin', child: Text('Administrador')),
                    DropdownMenuItem(value: 'Gerente', child: Text('Gerente')),
                    DropdownMenuItem(value: 'ProgSR', child: Text('Programador Sr')),
                    DropdownMenuItem(value: 'ProgJR', child: Text('Programador Jr'))
                  ], 
                  onChanged: ( valor ){
                    formvalues['rol'] = valor!;
                  },
                  ),
                const SizedBox(height: 20,),
                ElevatedButton(
                  onPressed: (){
                    // Quitar el teclado de la pantalla
                    FocusScope.of(context).requestFocus( FocusNode() );

                    if ( !myFormKey.currentState!.validate() ){
                      print('Formulario No valido');
                      return;
                    }
                    print(formvalues);
                    //Aqui lo que hago en una APP PRO
                    // es realizar una peticion http a algun backend
                  }, 
                  child: const SizedBox(
                    width: double.infinity,
                    child: Center(
                      child: Text('Guardar'),
                    ),
                  ))
              ],
            ),
          ),
        ),
      )
    );
  }
}

