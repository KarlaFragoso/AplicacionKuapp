package com.example.proyectokuap;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {

    private  static final String ruta = "https://karlafragoso.000webhostapp.com/registroCliente.php";
    private Map<String, String> parametros;
    public RegistroRequest(String username, String password, String direccion, String telefono, Response.Listener<String>listener){
        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("username",username+"");
        parametros.put("password",password+"");
        parametros.put("direccion",direccion+"");
        parametros.put("telefono",telefono+"");
    }

    @Override
    protected Map<String, String> getParams()  {
        return parametros;
    }
}
