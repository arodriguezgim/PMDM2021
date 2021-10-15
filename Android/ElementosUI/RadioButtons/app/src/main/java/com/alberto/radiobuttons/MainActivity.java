package com.alberto.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbFutbol = findViewById(R.id.cBFutbol);
        CheckBox cbBaloncesto = findViewById(R.id.cbBaloncesto);
        CheckBox cbPadel = findViewById(R.id.cbPadel);

        setTitle("CheckBoxes");
    }

    public void clickOnHobby(View view) {


        Boolean isChecked = ((CheckBox) view).isChecked();

        switch ( view.getId() ){
            case R.id.cBFutbol:
                if (isChecked){
                    Toast.makeText(this,"Futbol ha sido seleccionado",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Futbol ha sido desmarcado",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.cbBaloncesto:
                if (isChecked){
                    Toast.makeText(this,"Baloncesto ha sido marcado",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Baloncesto ha sido desmarcado",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.cbPadel:
                if (isChecked){
                    Toast.makeText(this,"Padel ha sido marcado",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Padel ha sido desmarcado",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}