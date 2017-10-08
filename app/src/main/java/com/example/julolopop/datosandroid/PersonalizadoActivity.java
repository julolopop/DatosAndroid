package com.example.julolopop.datosandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonalizadoActivity extends AppCompatActivity {

    private List<Cartas> cartasArray = new ArrayList<>();
    private List<Cartas> cartasArrayRes = new ArrayList<>();
    private int[] pos = new int[12];
    private ImageView[] cartas = new ImageView[12];
    private Random rnd = new Random();
    private int click1 = 0;
    private int click2 = 0;
    private int click0 = 0;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizado);

        cartas[0] = ((ImageView) findViewById(R.id.imageButton1));
        cartas[1] = ((ImageView) findViewById(R.id.imageButton2));
        cartas[2] = ((ImageView) findViewById(R.id.imageButton3));
        cartas[3] = ((ImageView) findViewById(R.id.imageButton4));
        cartas[4] = ((ImageView) findViewById(R.id.imageButton5));
        cartas[5] = ((ImageView) findViewById(R.id.imageButton6));
        cartas[6] = ((ImageView) findViewById(R.id.imageButton7));
        cartas[7] = ((ImageView) findViewById(R.id.imageButton8));
        cartas[8] = ((ImageView) findViewById(R.id.imageButton9));
        cartas[9] = ((ImageView) findViewById(R.id.imageButton10));
        cartas[10] = ((ImageView) findViewById(R.id.imageButton11));
        cartas[11] = ((ImageView) findViewById(R.id.imageButton12));

        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta1), 1, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta1), 1, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta2), 2, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta2), 2, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta3), 3, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta3), 3, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta4), 4, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta4), 4, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta5), 5, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta5), 5, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta6), 6, false));
        cartasArrayRes.add(new Cartas(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta6), 6, false));

        for (int i = 0; i < 12; i++) {
            if (i != 11) {
                int k = rnd.nextInt(cartasArrayRes.toArray().length - 1);
                cartasArray.add(cartasArrayRes.get(k));
                cartasArrayRes.remove(k);
            } else {
                cartasArray.add(cartasArrayRes.get(0));
                cartasArrayRes.remove(0);

            }
        }

    }


    public void Voltear(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                cartas[0].setImageBitmap(cartasArray.get(0).getImagen());
                click0 = 0;
                break;
            case R.id.imageButton2:
                cartas[1].setImageBitmap(cartasArray.get(1).getImagen());
                click0 = 1;
                break;
            case R.id.imageButton3:
                cartas[2].setImageBitmap(cartasArray.get(2).getImagen());
                click0 = 2;
                break;
            case R.id.imageButton4:
                cartas[3].setImageBitmap(cartasArray.get(3).getImagen());
                click0 = 3;
                break;
            case R.id.imageButton5:
                cartas[4].setImageBitmap(cartasArray.get(4).getImagen());
                click0 = 4;
                break;
            case R.id.imageButton6:
                cartas[5].setImageBitmap(cartasArray.get(5).getImagen());
                click0 = 5;
                break;
            case R.id.imageButton7:
                cartas[6].setImageBitmap(cartasArray.get(6).getImagen());
                click0 = 6;
                break;
            case R.id.imageButton8:
                cartas[7].setImageBitmap(cartasArray.get(7).getImagen());
                click0 = 7;
                break;
            case R.id.imageButton9:
                cartas[8].setImageBitmap(cartasArray.get(8).getImagen());
                click0 = 8;
                break;
            case R.id.imageButton10:
                cartas[9].setImageBitmap(cartasArray.get(9).getImagen());
                click0 = 9;
                break;
            case R.id.imageButton11:
                cartas[10].setImageBitmap(cartasArray.get(10).getImagen());
                click0 = 10;
                break;
            case R.id.imageButton12:
                cartas[11].setImageBitmap(cartasArray.get(11).getImagen());
                click0 = 11;
                break;
        }

        switch (cont) {
            case 0:
                cont++;
                click1 = click0;
                break;
            case 1:
                cont = 0;
                click2 = click0;

                if ((click1 != click2)) {
                    if (cartasArray.get(click1).getNumero() == cartasArray.get(click2).getNumero()) {
                        cartasArray.get(click1).setVolteado(true);
                        cartasArray.get(click2).setVolteado(true);
                    } else {
                        if (!cartasArray.get(click1).isVolteado())
                            cartas[click1].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta));
                        if (!cartasArray.get(click2).isVolteado())
                            cartas[click2].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta));
                    }
                } else {
                    if (!cartasArray.get(click1).isVolteado())
                        cartas[click1].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta));
                    if (!cartasArray.get(click2).isVolteado())
                        cartas[click2].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.carta));
                }

                break;
        }

    }
}
