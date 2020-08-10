package com.example.proyectokuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        final TextView mensaje = findViewById(R.id.mensaje);
        Intent i = this.getIntent();
        String username = i.getStringExtra("username");
        String telefono = i.getStringExtra("telefono");
        mensaje.setText(mensaje.getText()+" "+username);
    }
}

