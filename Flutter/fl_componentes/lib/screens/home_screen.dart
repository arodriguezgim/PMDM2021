import 'package:fl_componentes/themes/app_theme.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
   
  const HomeScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Home Screen')),
      body: ListView(
        children: [
          ListTile(
            title:    const Text('Lista Tipo 1'),
            leading:  const Icon(Icons.list, color: AppTheme.primary,),
            trailing: const Icon(Icons.arrow_forward_ios_outlined, color: AppTheme.primary,),
            onTap: ()=>Navigator.pushNamed(context, 'lista1'),
          ),
          const Divider(),
          ListTile(
            title:    const Text('Lista Tipo 2'),
            leading:  const Icon(Icons.list_alt_outlined, color: AppTheme.primary,),
            trailing: const Icon(Icons.arrow_forward_ios_outlined, color: AppTheme.primary,),
            onTap: ()=>Navigator.pushNamed(context, 'lista2'),
          ),
          const Divider(),
          ListTile(
            title:    const Text('Alertas'),
            leading:  const Icon(Icons.notification_add, color: AppTheme.primary,),
            trailing: const Icon(Icons.arrow_forward_ios_outlined, color: AppTheme.primary,),
            onTap: ()=>Navigator.pushNamed(context, 'alerta'),
          ),
          const Divider(),
          ListTile(
            title:    const Text('Tarjetas'),
            leading:  const Icon(Icons.card_giftcard, color: AppTheme.primary,),
            trailing: const Icon(Icons.arrow_forward_ios_outlined, color: AppTheme.primary,),
            onTap: ()=>Navigator.pushNamed(context, 'card'),
          ),
          const Divider(),
          
        ],
      )
    );
  }
}