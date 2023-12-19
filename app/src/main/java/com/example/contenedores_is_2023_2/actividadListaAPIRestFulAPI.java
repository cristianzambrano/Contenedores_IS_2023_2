package com.example.contenedores_is_2023_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedores_is_2023_2.Adaptadores.AdaptadorUsuarios;
import com.example.contenedores_is_2023_2.Modelos.Usuario;
import com.example.contenedores_is_2023_2.WebServices.Asynchtask;
import com.example.contenedores_is_2023_2.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class actividadListaAPIRestFulAPI
        extends AppCompatActivity
        implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_lista_apirest_fuk_api);

        lstOpciones = (ListView)findViewById(R.id.lstLista3);

        View header = getLayoutInflater().inflate(R.layout.ly_cabecera, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, actividadListaAPIRestFulAPI.this, actividadListaAPIRestFulAPI.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        AdaptadorUsuarios adapatorUsuario = new AdaptadorUsuarios(this, lstUsuarios);

        lstOpciones.setAdapter(adapatorUsuario);

    }
}