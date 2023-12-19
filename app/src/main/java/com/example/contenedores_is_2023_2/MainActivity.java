package com.example.contenedores_is_2023_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener{

    TextView txtItemSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Datos
        final String[] datos =
                new String[]{"ALVAREZ MORA JOSE ANDRES",
                            "MORALES VERA JEAN PIERRE",
                            "NAVAS RIVERA RAFAEL ALEXANDER",
                            "REYES PALACIOS LUIS AARON",
                            "TRIANA ARRIETA KERLY MIKAELA",
                            "VERA ZAMBRANO JOSSELYN JELITZA"};
        //2.- Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        //3. La Vista
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbOpciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        txtItemSelected = findViewById(R.id.txtItemSeleccionado);
        cmbOpciones.setOnItemSelectedListener(this);


        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        ListView lstOpciones = (ListView)findViewById(R.id.lstLista);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getApplicationContext(),
                parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_LONG).show();

        /*Snackbar.make(this.getApplicationContext(), view,
                parent.getItemAtPosition(position).toString(),
                Snackbar.LENGTH_LONG).show();*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txtItemSelected.setText("Item Seleccionado\n" +
                parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        txtItemSelected.setText("");
    }


}