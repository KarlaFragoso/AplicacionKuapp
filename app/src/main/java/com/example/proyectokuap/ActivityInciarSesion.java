package com.example.proyectokuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityInciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inciar_sesion);

        TextView registro = findViewById(R.id.registroLogin);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(ActivityInciarSesion.this, ActivityRegistro.class);
                ActivityInciarSesion.this.startActivity(registro);
                finish();

            }
        });
    }
}
