package com.example.julolopop.datosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {


    private Button Eje1;
    private Button Eje2;
    private Button Eje3;
    private Button Eje4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Eje1 = ((Button)findViewById(R.id.ejercicio1));
        Eje2 = ((Button)findViewById(R.id.ejercicio2));
        Eje3 = ((Button)findViewById(R.id.ejercicio3));
        Eje4 = ((Button)findViewById(R.id.ejercicio4));

        //Ejercicio 1 Conversor
        Eje1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eje1 = new Intent(MenuActivity.this,ConversorActivity.class);
                startActivity(eje1);
            }
        });

        //Ejercicio 2 Web
        Eje2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eje2 = new Intent(MenuActivity.this,WebIntermedioActivity.class);
                startActivity(eje2);
            }
        });

        //Ejercicio 3 Cafe
        Eje3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eje3 = new Intent(MenuActivity.this,CoffeActivity.class);
                startActivity(eje3);
            }
        });

        //Ejercicio 4 Personal
        Eje4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eje4 = new Intent(MenuActivity.this,PersonalizadoActivity.class);
                startActivity(eje4);
            }
        });

    }
}
