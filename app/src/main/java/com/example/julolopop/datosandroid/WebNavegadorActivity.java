package com.example.julolopop.datosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebNavegadorActivity extends AppCompatActivity {

    WebView _navegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_navegador);
        _navegador = ((WebView)findViewById(R.id.Navegador));

        _navegador.setWebViewClient(new WebViewClient());
        _navegador.loadUrl(getIntent().getExtras().getString("Url"));

    }
}
