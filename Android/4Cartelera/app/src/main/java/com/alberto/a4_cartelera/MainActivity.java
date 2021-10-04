package com.alberto.a4_cartelera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView movieImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieImageview = findViewById(R.id.imagenPelicula);

        Button buttonGravity = findViewById(R.id.btnGravity);
        Button buttonJumanji = findViewById(R.id.btnJumanji);
        Button buttonlion = findViewById(R.id.btnReyLeon);
        Button buttonStarWars = findViewById(R.id.btnStarWars);
        Button buttonOrigen = findViewById(R.id.btnOrigen);
        Button buttonToyStory = findViewById(R.id.btnToyStory);

        buttonGravity.setOnClickListener(this);
        buttonJumanji.setOnClickListener(this);
        buttonlion.setOnClickListener(this);
        buttonStarWars.setOnClickListener(this);
        buttonOrigen.setOnClickListener(this);
        buttonToyStory.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        int buttonId = view.getId();
        int imageId;

        switch (buttonId){

            case R.id.btnGravity:
                imageId = R.drawable.gravity;
                break;

            case R.id.btnJumanji:
                imageId = R.drawable.jumanju;
                break;

            case R.id.btnReyLeon:
                imageId = R.drawable.reyleon;
                break;

            case R.id.btnStarWars:
                imageId = R.drawable.starwars;
                break;

            case R.id.btnOrigen:
                imageId = R.drawable.origen;
                break;

            case R.id.btnToyStory:
                imageId = R.drawable.toystory;
                break;
            default:
                imageId = 0;
        }

        if ( imageId != 0 ){
            movieImageview.setImageDrawable(ContextCompat.getDrawable(this, imageId));
        }


    }

















}