package com.example.proyectobasen1stgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobasen1stgo.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {

    private EditText code, intensi,clas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        intensi = findViewById(R.id.inten);
        clas = findViewById(R.id.clas);

    }

    //Método para guardar clases
    public  void guardarclases(View view)
    {
        //Obtenemos mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db= admin.getWritableDatabase(); //Permite sobreescribir la base de datos el getW..

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty())
        {
            //guardo en la basedatos
            ContentValues cont = new ContentValues(); //Me permite añadir valores y remplazarlo por los de la base de datosw
            cont.put("codigo", codigo);
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.insert("clases",null,cont); //Guardo en la base de datos
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has guardado una clase",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getBaseContext(), "Tiene campos vacios por favor rellenar", Toast.LENGTH_SHORT).show();
        }

    }


    //Método para consultar Clases
    public  void  mostrarClases(View view)
    {
        //Obtenemos mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db= admin.getWritableDatabase(); //Le entrega permisos de sobreescritura

        String codigo = code.getText().toString();
        if (!codigo.isEmpty())
        {
            //Permite mostrar los campos de la bd por posición
            Cursor file = db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo="+codigo,null);

            if (file.moveToFirst())//Revisa si nuestra consulta tiene valores
            {
                clas.setText(file.getString(0));
                intensi.setText(file.getString(1));
            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay clase asociada", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "El código esta vacio", Toast.LENGTH_SHORT).show();
        }


    }

    //Método para eliminar clases
    public  void eliminarClases(View view)
    {
        //Obtenemos mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String codigo = code.getText().toString();
        if(!codigo.isEmpty())
        {
            db.delete("clases","codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Se ha elimanado la clase "+codigo, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"No puede venir vacio el código", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para Actualizar clases
    public  void  actualizarClases(View view)
    {
        //Obtenemos mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty())
        {
            //Actualizo
            ContentValues cont = new ContentValues();
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.update("clases", cont, "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has actualizado", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"No puede venir vacio por favor rellenar", Toast.LENGTH_SHORT).show();
        }

    }

    ////Método para limpiar los campos
    private void Clean()
    {
        code.setText("");
        clas.setText("");
        intensi.setText("");
    }


}