package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_act extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //Tarea Pesada los dispositivos no lo soportan
    public  void Task(View view)
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
    }
}