package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import objetos.Insumos;

public class insumos_act extends AppCompatActivity {
        private Spinner insumos;
        private TextView result;
        private Insumos ins = new Insumos();//Instanciando el objeto insumos
        private RatingBar calificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos= findViewById(R.id.insumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rb);
        result.setVisibility(View.INVISIBLE);
        //Recibo los extras
        Bundle bun = getIntent().getExtras();// recibo el intent
        String[] listado = bun.getStringArray("insumos"); // obtengo mi referencia array

        ArrayAdapter adaptIn = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptIn);
    }

        public  void calcular(View view)
        {
            String opcion = insumos.getSelectedItem().toString(); //Obtengo la selección
            int resultado = 0;

            for(int i=0; i< opcion.length(); i++) //Recorre las opciones
            {
                if(opcion.equals(ins.getInsumos()[i])) //si seleccione lo que elegi
                {
                    resultado = ins.añadirAdicional(ins.getPrecios()[i], 350); //obtengo los  precios
                    calificar.setRating(i);
                    break;
                }

            }
            result.setVisibility(View.VISIBLE);
            result.setText("La opcion es: " + opcion + " El precio es: $ " + resultado);
        }


}
