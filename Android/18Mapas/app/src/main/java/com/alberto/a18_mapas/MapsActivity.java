package com.alberto.a18_mapas;

import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.alberto.a18_mapas.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Le decimos que los estilos de mapa que queremos usar
        // estan en el recurso json que nos hemos traido
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this,R.raw.style_json)
            );
            if (!success){
                Log.e("MAPAS", "Existe el recurso pero no lo cargamos bien");
            }
        } catch (Resources.NotFoundException e){
            Log.e("MAPAS", "No Existe el recurso json ");
        }

        mMap = googleMap;

        // Puedo seleccionar el tipo de mapa que queremos en nuestra APP
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // ME creo la ubicacion de Teruel
        LatLng teruel = new LatLng(40.336139,-1.107440);

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions()
                .position(teruel)
                .title("Marker en Teruel")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        );
        // Nos creamos el objeto LatLng de las tres oficinas
        LatLng oficina1 = new LatLng(40.336139,-1.104079);
        LatLng oficina2 = new LatLng(40.331565,-1.107254);
        LatLng oficina3 = new LatLng(40.332114,-1.108394);
        mMap.addMarker(
                new MarkerOptions()
                .position(oficina1)
                .title("Oficina 1")
                .snippet("Tfno: 987 654 345")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.alfiler))
        );
        mMap.addMarker(
                new MarkerOptions()
                        .position(oficina2)
                        .title("Oficina 2")
                        .snippet("Tfno: 987 654 345")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.alfiler))
        );
        mMap.addMarker(
                new MarkerOptions()
                        .position(oficina3)
                        .title("Oficina 3")
                        .snippet("Tfno: 987 654 345")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        );



        mMap.moveCamera(CameraUpdateFactory.newLatLng(teruel));
    }
}