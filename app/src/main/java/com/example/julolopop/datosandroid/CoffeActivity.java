package com.example.julolopop.datosandroid;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CoffeActivity extends AppCompatActivity {

    private CountDownTimer contador;
    private int minutos;
    private int segundos;
    private int ncafes;
    private TextView tiempo;
    private TextView cafes;
    private Button btnComenzar;
    private Button btnMas;
    private Button btnMenos;
    private boolean bloquear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);

        this.tiempo = (TextView) findViewById(R.id.tiempo);
        this.btnMas = ((Button) findViewById(R.id.mas));
        this.btnMenos = ((Button) findViewById(R.id.menos));
        this.btnComenzar = ((Button) findViewById(R.id.comenzar));
        this.cafes = ((TextView) findViewById(R.id.ncafes));

        this.minutos = 0;
        this.segundos = 0;
        this.bloquear = true;

        this.btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bloquear) {
                    if (segundos == 30) {
                        segundos = 0;
                        minutos++;
                    } else {
                        segundos = 30;
                    }
                    tiempo.setText(minutos + ":" + String.format("%02d", segundos));
                }
            }
        });
        this.btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bloquear) {
                    if ((minutos + segundos != 0)){
                        if (segundos == 0) {
                            segundos = 30;
                            minutos--;
                        } else {
                            segundos = 0;
                        }
                        tiempo.setText(minutos + ":" + String.format("%02d", segundos));
                    }
                }
            }
        });
        this.btnComenzar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view) {
                if (bloquear) {
                    contador = new CountDownTimer(((minutos * 60) + segundos) * 1000, 1000) {
                        @Override
                        public void onTick(long l) {


                            if (segundos <= 0) {
                                segundos = 59;
                                minutos--;
                            } else {
                                segundos--;
                            }
                            tiempo.setText(minutos + ":" + String.format("%02d", segundos));
                        }

                        @Override
                        public void onFinish() {
                            segundos = 0;
                            tiempo.setText(minutos + ":" + String.format("%02d", segundos));
                            bloquear = !bloquear;
                            ncafes++;
                            cafes.setText(String.valueOf(ncafes));
                        }
                    }.start();
                    bloquear = !bloquear;
                }else{
                    contador.cancel();
                    bloquear = !bloquear;
                    contador= null;
                }
            }
        });


    }
}
