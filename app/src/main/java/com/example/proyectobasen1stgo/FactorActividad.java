package com.example.proyectobasen1stgo;

public class FactorActividad
{
    private String[] intensidadDeActividad = {"Sedentario-2Veces", "Poco1x3Veces","Moderada3x5Veces","Altapesada+5Veces"};

    public String[] getIntensidadDeActividad()
    {
        return intensidadDeActividad;
    }

    public void setIntensidadDeActividad(String[] intensidadDeActividad)
    {
        this.intensidadDeActividad = intensidadDeActividad;
    }

    public  int calcularpeso(int valor, int pes)
    {
        int resultadopes= valor * pes;
        return resultadopes;
    }
    public  int calcularaltura(int valor, int alt)
    {
        int resultadoaltu= valor * alt;
        return resultadoaltu;
    }

    public  int calcularEdad(float valor, int ago)
    {
        float resultadoedad= valor * ago;
        return (int) resultadoedad;
    }
}
