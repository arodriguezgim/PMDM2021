package com.alberto.a17geoposicionamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // 1 - Iniciamos la variable
    Button btnLocation;
    TextView tv1, tv2, tv3, tv4, tv5;
    // 3
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2- Asignamos las variables
        btnLocation = findViewById(R.id.btn_location);
        tv1 = findViewById(R.id.text_view1);
        tv2 = findViewById(R.id.text_view2);
        tv3 = findViewById(R.id.text_view3);
        tv4 = findViewById(R.id.text_view4);
        tv5 = findViewById(R.id.text_view5);

        // 4 - Inicializamos el objeto FusedLocation...
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // 5 - Procesamos el metodo clickk del boton
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerLocalizacion();
            }
        });
    }

    private void obtenerLocalizacion() {

        // Iniciamos la localizacion
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {

                Location location = task.getResult();
                if (location != null) {
                    try {
                        // Iniciamos el Geocoder
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        // Iniciamos la lista de direcciones
                        List<Address> direcciones = geocoder.getFromLocation(
                                location.getLatitude(),
                                location.getLongitude(),
                                1
                        );
                        // Escribimos la localizacion en nuestra APP
                        tv1.setText(Html.fromHtml(
                                "<font color='6200EE'><b>Latitud: </b><br><font>" + direcciones.get(0).getLatitude()
                        ));
                        tv2.setText(Html.fromHtml(
                                "<font color='6200EE'><b>Longitud: </b><br><font>" + direcciones.get(0).getLongitude()
                        ));
                        // Podemos obtener el País donde estamos
                        tv3.setText(Html.fromHtml(
                                "<font color='6200EE'><b>País: </b><br><font>" + direcciones.get(0).getCountryName()
                        ));
                        // Podemos obtener la localidad dpnde estamos
                        tv4.setText(Html.fromHtml(
                                "<font color='6200EE'><b>Localidad: </b><br><font>" + direcciones.get(0).getLocality()
                        ));
                        // Podemos obtener la direccion donde estamos
                        tv5.setText(Html.fromHtml(
                                "<font color='6200EE'><b>Direccion: </b><br><font>" + direcciones.get(0).getAddressLine(0)
                        ));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}




















