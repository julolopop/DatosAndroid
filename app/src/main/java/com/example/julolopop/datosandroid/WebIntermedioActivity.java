package com.example.julolopop.datosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WebIntermedioActivity extends AppCompatActivity {

    private TextView _txvUrl;
    private Button _btnIr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_intermedio);
        _txvUrl=((TextView)findViewById(R.id.Url));
        _btnIr=((Button)findViewById(R.id.BtnIr));


        _txvUrl.setText(getResources().getString(R.string.url));

        //Ejercicio Navegador
        _btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Url",_txvUrl.getText().toString());

                Intent irNavegador = new Intent(WebIntermedioActivity.this,WebNavegadorActivity.class);

                irNavegador.putExtras(bundle);

                startActivity(irNavegador);
            }
        });
    }
}
