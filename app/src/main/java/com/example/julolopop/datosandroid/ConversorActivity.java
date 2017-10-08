package com.example.julolopop.datosandroid;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConversorActivity extends AppCompatActivity {


    //inicializacion de Propiedades
    private RadioButton _euroAUsa;
    private RadioButton _usaAEuro;
    private Button _btnConvertir;
    private EditText _editNumero1;
    private EditText _editNumero2;
    private TextView _txv1;
    private TextView _txv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        //Inicializacion de las propiedades
        _euroAUsa = ((RadioButton) findViewById(R.id.checkEuro));
        _usaAEuro = ((RadioButton) findViewById(R.id.checkUsa));
        _btnConvertir = ((Button) findViewById(R.id.button));
        _editNumero1 = ((EditText) findViewById(R.id.Numero1));
        _editNumero2 = ((EditText) findViewById(R.id.Numero2));
        _txv1 = ((TextView) findViewById(R.id.textView));
        _txv2 = ((TextView) findViewById(R.id.textView2));

        //inicio del evento OnClick del Boton de convertir
        _btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //propiedades interna del metodo
                double doble;
                //try para los fallos de comversion del parse
                try {
                    doble = Double.parseDouble(_editNumero1.getText().toString());
                } catch (Exception e) {
                    //al fallo de ExceptionNullReferent y otros tomar como si el _editNumero1 sea 0
                    _editNumero1.setText("0");
                    doble = 0;

                    /*
                    AlertDialog.Builder a = new AlertDialog.Builder(conversor.this);
                    a.setTitle("Error");
                    a.setMessage("Deve poner el valor de la moneda para Convertirlo a otra moneda deseada");
                    a.create();
                    a.show();
                    */

                    Snackbar.make(view, "Deve poner el valor de la moneda para Convertirlo a otra moneda deseada", Snackbar.LENGTH_LONG)
                            .setAction("Acción", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i("Snackbar", "Pulsada acción snackbar!");
                                }
                            }).show();

                    //http://www.sgoliver.net/blog/notificaciones-en-android-iv-snackbar/


                }


                convertir(doble);


            }
        });
        //Lisener del evento OnClick de los RadioButton de _euroAUsa y _usaAEuro cambio de TextView
        _euroAUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _txv1.setText(R.string.euros);
                _txv2.setText(R.string.usa);
            }
        });
        _usaAEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _txv1.setText(R.string.usa);
                _txv2.setText(R.string.euros);
            }
        });


    }

    //Metodo convertir que toma el valor de _editNumero1 y segun El RadioButton selecionado multipica x valor en _editNumero2
    private void convertir(double doble) {

        if (_euroAUsa.isChecked()) {
            _editNumero2.setText(String.format("%.2f", doble * 1.17));
        } else {
            _editNumero2.setText(String.format("%.2f", doble * .84));
        }

    }

}

