package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import objetos.Administrador;
import objetos.Insumos;

public class MainActivity extends AppCompatActivity {
    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador();
    private Insumos ins = new Insumos();//Instanciando el objeto insumos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // llamamos elementos por id
        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        msj.setVisibility(View.INVISIBLE);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);

        //para implimentar la clase asincrona necesito el boton desde su listener
        //Lo que va hacer mi button
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Correr mi tarea asincrona
                new Task().execute();
            }
        });

    }

    public void face(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);

    }

    public void twiter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);

    }

    public void youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);

    }

    public void info(View view)
    {
        Intent i = new Intent(getBaseContext(), Info_act.class);
        startActivity(i);
    }

    //Tarea asincrona para correr procesos de segundo plano
    class Task extends AsyncTask<String, Void, String> {
        //Configuración inicial de mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        //Se usa para realizar procesos en 2do plano o tarea pesada
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        //Eleginos que va a ocurrir cuando termine mi tarea pesada
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario) {
                case "Kris":
                    if (usuario.equals(userObj) && contrasena.equals(passObj)) {
                        //inicio
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Casa_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.trim().equals("") || contrasena.trim().equals("")) {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Ninguno de los campos puede estar vacio");

                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(passObj)) {
                        msj.setText("Campos Incorrectos");
                        msj.setVisibility(View.VISIBLE);
                    }

                    //Intent i = new Intent(getBaseContext(), Casa_act.class);
                    //startActivity(i);
            }


        }






  /*  public void logueo(View view)
    {
        String usuario= user.getText().toString().trim();
        String contrasena= pass.getText().toString();

        String userObj = adm.getUser().trim();
        String passObj = adm.getPass().trim();

        switch (usuario) {
            case "Kris":
                if (usuario.equals(userObj) && contrasena.equals(passObj)) {
                    //inicio
                    msj.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(this, Home_act.class);

                    //preparando los extras

                    Bundle bun = new Bundle();//Intercambia arreglos
                    bun.putStringArray("insumos", ins.getInsumos());//llenando elbundle
                    i.putExtras(bun);//paso el bundle

                    startActivity(i);
                }
                break;
            case "":
                if (usuario.trim().equals("") || contrasena.trim().equals("")) {
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Ninguno de los campos puede estar vacio");

                }
                break;
            default:
                if (!usuario.equals(userObj) && !contrasena.equals(passObj)) {
                    msj.setText("Campos Incorrectos");
                    msj.setVisibility(View.VISIBLE);
                }

        }

    }*/

        //Intenta implicitos


       /* public void face(View view)
        {
            Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
            i.setData(Uri.parse("https://www.facebook.com/"));
            startActivity(i);
        }

        public void twiter(View view)
        {
            Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
            i.setData(Uri.parse("https://www.twitter.com/"));
            startActivity(i);
        }

        public void youtube(View view)
        {
            Intent i = new Intent(Intent.ACTION_VIEW); //Abre un sitio web
            i.setData(Uri.parse("https://www.youtube.com/"));
            startActivity(i);
        }

        public void info(View view)
        {
            Intent i = new Intent(getBaseContext(), Info_act.class);
            startActivity(i);
        }*/



    }
}