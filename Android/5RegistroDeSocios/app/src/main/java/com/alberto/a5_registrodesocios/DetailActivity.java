package com.alberto.a5_registrodesocios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nombreSocio = findViewById(R.id.tvNombre);
        TextView apellidoSocio = findViewById(R.id.tvApellido);
        TextView bioSocio = findViewById(R.id.tvBio);
        RatingBar puntuacion = findViewById(R.id.rbPuntuacion);

        ImageView imagen = findViewById(R.id.imageView2);

        // 1 - Recogemos la información procedente del MainActivity
        Bundle extras = getIntent().getExtras();
        // 2 - Enlazamos cada campo con el dato que corresponde
        // nombreSocio.setText(extras.getString("nombreSocio") );
        // apellidoSocio.setText(extras.getString("apellidoSocio"));
        // bioSocio.setText(extras.getString("bioSocio"));
        // puntuacion.setRating(extras.getFloat("puntuacion"));

        // 2b - Obtener el objeto que le hemos pasado
        Socio nuevoSocio = extras.getParcelable("nuevoSocio");

        Bitmap imagenSocio = extras.getParcelable("imagenSocio");

        nombreSocio.setText( nuevoSocio.getNombre());
        apellidoSocio.setText( nuevoSocio.getApellidos() );
        bioSocio.setText( nuevoSocio.getBiografia() );
        puntuacion.setRating(nuevoSocio.getPuntuacion() );

        if ( imagenSocio != null){
            imagen.setImageBitmap(imagenSocio);
        }


    }
}