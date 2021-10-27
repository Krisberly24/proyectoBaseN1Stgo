package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    //Intent implicitos

    public void marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); //Accion para el marcado telefonico
        i.setData(Uri.parse("tel:" + "961660356"));
        startActivity(i);
    }

    //Intent explicito
    public void mapa(View view)
    {
        Intent i = new  Intent( this, MapsActivity.class);
        startActivity(i);
    }
}