package com.example.proyectokuap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;


import android.app.DownloadManager;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
public class ActivityRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        final EditText usernameT   = findViewById(R.id.usernameRegistro);
        final EditText passwordT    = findViewById(R.id.passwordRegistro);
        final EditText direccionT  = findViewById(R.id.direccionRegistro);

        final EditText telefonoT     = findViewById(R.id.telefonoRegistro);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username   = usernameT.getText().toString();
                String password    = passwordT.getText().toString();
                String direccion  = direccionT.getText().toString();

                String telefono  = telefonoT.getText().toString();


                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok == true){
                                Intent i = new Intent(ActivityRegistro.this,MainActivity.class);
                                ActivityRegistro.this.startActivity(i);
                                ActivityRegistro.this.finish();
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(ActivityRegistro.this);
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

                RegistroRequest r = new RegistroRequest(username,password,direccion,telefono,respuesta);
                RequestQueue cola = Volley.newRequestQueue(ActivityRegistro.this);
                cola.add(r);
            }

        });

    }
}
