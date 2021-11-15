package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import objetos.Insumos;

public class Casa_act extends AppCompatActivity {
    private VideoView video;
    private Insumos ins = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        video = findViewById(R.id.vwgym); //Llamo al video

        //Obtener la ruta del video
        String ruta = "android.resource://" + getPackageName() + "/" +R.raw.video;
        //Consultar al content provide
        //Lo hacemos atraves de uri
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);//le pasamos el video al videView
        video.start(); //Inicio automático


        /*//Controles para el video
        MediaController media = new MediaController(this);
        video.setMediaController(media);*/
    }

    //Método para irme a insumos

    public void Insumos(View view)
    {

        Intent i = new Intent(this, insumos_act.class);
        //preparando los extras

        Bundle bun = new Bundle();//Intercambia arreglos
        bun.putStringArray("insumos", ins.getInsumos());//llenando elbundle
        i.putExtras(bun);//paso el bundle
        startActivity(i);
    }

    //Método para irme a clases
    public void clases(View view)
    {
        Intent i = new Intent(this, Clases_act.class);
        startActivity(i);
    }


    //Tarea Pesada los dispositivos no lo soportan
    /*public  void Task(View view)
    {
        try
        {
            for(int i = 0; i <= 10; i++)
            {
                Thread.sleep(1000);
                Toast.makeText(this, "Esta es mi tarea pesada", Toast.LENGTH_SHORT).show();
            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace(); //imprime el error capturado desde el stock
        }
    }*/



}