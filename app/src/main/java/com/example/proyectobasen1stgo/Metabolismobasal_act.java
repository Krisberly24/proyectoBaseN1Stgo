package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Metabolismobasal_act extends AppCompatActivity {

    private Spinner actividad;
    private CheckBox mujer, hombre;
    private EditText peso,edad,altura;
    private TextView resultado, resultadototal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metabolismobasal);



        actividad =(Spinner)findViewById(R.id.spActividad);
        mujer = (CheckBox)findViewById(R.id.cBMujer);
        hombre = (CheckBox)findViewById(R.id.cbHombre);
        resultadototal= (TextView)findViewById(R.id.txtResultadoTotal);
        peso= (EditText)findViewById(R.id.txtNPeso);
        edad= (EditText)findViewById(R.id.txtEdad);
        altura= (EditText)findViewById(R.id.txtNAltura);
        resultado =(TextView)findViewById(R.id.txtResultMB);
        resultado.setVisibility(View.INVISIBLE);
        resultadototal.setVisibility(View.INVISIBLE);

        //Instanciando
        FactorActividad factividad = new FactorActividad();

        //Obteniendo la lista

        String[]lista = factividad.getIntensidadDeActividad();

        ArrayAdapter adaptActividad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        actividad.setAdapter(adaptActividad);
    }

    public void deficitcalorias(View view) {
        FactorActividad fa = new FactorActividad();
        String actividadSerie = actividad.getSelectedItem().toString();
        int resultadoTotal1, resultadote, valor1, valor2, valor3;
        double factr;
        int pesito = Integer.parseInt(peso.getText().toString());
        int edadsita = Integer.parseInt(edad.getText().toString());
        int alturita = Integer.parseInt(altura.getText().toString());

        if (peso.getText().length()>0 & edad.getText().length()>0 & altura.getText().length()>0)
        {
            if (mujer.isChecked() ) {

                valor1 = fa.calcularpeso(10, pesito);
                valor2 = fa.calcularaltura((int) 6.25, alturita);
                valor3 = fa.calcularEdad(5, edadsita);

                switch (actividadSerie)
                {
                    case "Sedentario-2Veces":
                        resultadote = ((valor1 + valor2) - (valor3) -165);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.2;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;

                    case "Poco1x3Veces":
                        resultadote = ((valor1 + valor2) - (valor3) -165);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.375;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;
                    case "Moderada3x5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 165);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.55;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;
                    case "Altapesada+5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 165);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.55;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;


                }





            } else if (hombre.isChecked()) {
                valor1 = fa.calcularpeso(10, pesito);
                valor2 = fa.calcularaltura((int) 6.25, alturita);
                valor3 = fa.calcularEdad(5, edadsita);

                switch (actividadSerie)
                {
                    case "Sedentario-2Veces":
                        resultadote = ((valor1 + valor2) - (valor3) + 5);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.2;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;

                    case "Poco1x3Veces":
                        resultadote = ((valor1 + valor2) - (valor3) + 5);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.375;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;
                    case "Moderada3x5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) + 5);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.55;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;
                    case "Altapesada+5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) + 5);

                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factr = resultadote * 1.55;
                        resultadoTotal1 = (int) (factr -500);

                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tus calorias diarias no deben superar los: " + resultadoTotal1 + "Para obtener un deficit calorico");
                        break;


                }


            }
            else
            {
                Toast.makeText(this, "Por favor seleccione el genero para continuar", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void superavit(View view)
    {
        FactorActividad fa = new FactorActividad();
        String actividadSerie = actividad.getSelectedItem().toString();
        int resultadoTotal1, resultadote, valor1, valor2, valor3,factorAct;
        int pesito = Integer.parseInt(peso.getText().toString());
        int edadsita = Integer.parseInt(edad.getText().toString());
        int alturita = Integer.parseInt(altura.getText().toString());

        if (peso.getText().length() > 0 & edad.getText().length() > 0 & altura.getText().length() > 0) {
            valor1 = fa.calcularpeso(10, pesito);
            valor2 = fa.calcularaltura((int) 6.25, alturita);
            valor3 = fa.calcularEdad(5, edadsita);
            if (mujer.isChecked()) {

                switch (actividadSerie)
                {
                    case "Sedentario-2Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.375);
                        resultadoTotal1 = factorAct + 100;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Poco1x3Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.55);
                        resultadoTotal1 = factorAct + 100;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Moderada3x5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.73);
                        resultadoTotal1 = factorAct + 100;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Altapesada+5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.2);
                        resultadoTotal1 = factorAct + 100;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;


                }


            } else if (hombre.isChecked()) {

                switch (actividadSerie)
                {
                    case "Sedentario-2Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.375);
                        resultadoTotal1 = factorAct + 200;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Poco1x3Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.55);
                        resultadoTotal1 = factorAct + 200;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Moderada3x5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.73);
                        resultadoTotal1 = factorAct + 200;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;
                    case "Altapesada+5Veces":
                        resultadote = ((valor1 + valor2) - (valor3) - 161);
                        resultado.setVisibility(View.VISIBLE);
                        resultado.setText("Tu metabolismo basal es de: " + resultadote);
                        factorAct = (int) (resultadote * 1.2);
                        resultadoTotal1 = factorAct + 200;
                        resultadototal.setVisibility(View.VISIBLE);
                        resultadototal.setText("Tu superávit calórico es de: " + resultadoTotal1);
                        break;


                }


            } else {
                Toast.makeText(this, "Por favor seleccione el genero para continuar", Toast.LENGTH_SHORT).show();
            }

        }


    }
}