import 'package:flutter/material.dart';

class TarjetaTipo1 extends StatelessWidget {
  const TarjetaTipo1({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          const ListTile(
            leading: Icon( Icons.photo_album_outlined,),
            title: Text('Soy un título'),
            subtitle: Text('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 5),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                TextButton(
                  onPressed: (){}, 
                  child: const Text('Ok'),
                ),
                TextButton(
                  onPressed: (){}, 
                  child: const Text('Cancelar'),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}