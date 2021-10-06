package com.alberto.a5_registrodesocios;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private Bitmap fotoSocioTomada;
    private ImageView socioImagen;


    // SOLUCIONAMOS EL DEPRECATED DEL ACTIVITYFORRESULT
    ActivityResultLauncher<Intent> lazarCamaradeFotosActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        if (data != null){
                            fotoSocioTomada = data.getExtras().getParcelable("data");
                            socioImagen.setImageBitmap(fotoSocioTomada);
                        }
                    }
                }
            });
    // FIN SOLUCION DEPRECATED DEL ActivityForResult

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos las vistas con la parte lógica
        Button btnGuardar = findViewById(R.id.boton_guardar);
        EditText etNombre = findViewById(R.id.nombre_socio);
        EditText etApellido = findViewById(R.id.apellido_socio);
        EditText etBio = findViewById(R.id.editTextBio);
        RatingBar rtBar = findViewById(R.id.ratingBar);






        // PARTE B: 1 - Creamos una variable de tipo Imagen
        socioImagen = findViewById(R.id.socio_imagen);
        // PARTE B: 2 - Implementamos el onclickListener
        socioImagen.setOnClickListener(v -> abrirCamara());


        btnGuardar.setOnClickListener(view -> {

            // Obtenemos los campos introducidos en las vistas
            String nombreSocio = etNombre.getText().toString();
            String apellidoSocio = etApellido.getText().toString();
            String bioSocio = etBio.getText().toString();
            Float puntuacion = rtBar.getRating();

            // 1 - Nos creamos el intent irDetalle
            Intent irDetalle = new Intent(this, DetailActivity.class);

            // 2- Añadimos toda la información que queremos pasar al detailActivity
            // irDetalle.putExtra("nombreSocio",nombreSocio);
            // irDetalle.putExtra("apellidoSocio",apellidoSocio);
            // irDetalle.putExtra("bioSocio",bioSocio);
            // irDetalle.putExtra("puntuacion",puntuacion);

            // 2b.1  - Creamos un objeto socio con los datos que corresponden
            Socio nuevoSocio = new Socio(
                    nombreSocio,
                    apellidoSocio,
                    bioSocio,
                    puntuacion
            );
            // 2b.2 Enviamos el objeto al intent
            irDetalle.putExtra("nuevoSocio",nuevoSocio);

            // 3- Nos vamos al Detail Activity
            startActivity(irDetalle);

        });

    }

    private void abrirCamara() {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(camaraIntent, 1000);
        lazarCamaradeFotosActivity.launch(camaraIntent);
    }
/*
    Este CODIGO YA NO ES NECESARIO 

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == Activity.RESULT_OK && requestCode == 1000 ){
            if (data != null){
                fotoSocioTomada = data.getExtras().getParcelable("data");
                socioImagen.setImageBitmap(fotoSocioTomada);
            }
        }
    }
    */

}