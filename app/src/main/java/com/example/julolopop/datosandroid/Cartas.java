package com.example.julolopop.datosandroid;

import android.graphics.Bitmap;

/**
 * Created by Julolopop on 08/10/2017.
 */

public class Cartas {
    private Bitmap imagen;
    private int numero;
    private boolean volteado;

    public boolean isVolteado() {
        return volteado;
    }

    public void setVolteado(boolean volteado) {
        this.volteado = volteado;
    }

    public Cartas(Bitmap imagen, int numero, boolean volteado) {
        this.imagen = imagen;
        this.numero = numero;
        this.volteado = volteado;
    }


    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
