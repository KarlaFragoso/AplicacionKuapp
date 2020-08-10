package com.example.proyectokuap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityInciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inciar_sesion);

        TextView registro = findViewById(R.id.registroLogin);
        Button btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        final EditText usernameT = findViewById(R.id.usernameLogin);
        final EditText passwordT = findViewById(R.id.passwordLogin);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(ActivityInciarSesion.this, ActivityRegistro.class);
                ActivityInciarSesion.this.startActivity(registro);
                finish();

            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameT.getText().toString();
                final String password = passwordT.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok = true){
                                String username = jsonRespuesta.getString("username");
                                String telefono = jsonRespuesta.getString("telefono");
                                Intent bienvenido = new Intent(ActivityInciarSesion.this, Bienvenido.class);
                                bienvenido.putExtra("username", username);
                                bienvenido.putExtra("telefono",telefono);

                                ActivityInciarSesion.this.startActivity(bienvenido);
                                ActivityInciarSesion.this.finish();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(ActivityInciarSesion.this);
                                alerta.setMessage("Fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(username,password,respuesta);
                RequestQueue cola = Volley.newRequestQueue(ActivityInciarSesion.this);
                cola.add(r);
            }
        });
    }
}
