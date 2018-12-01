package com.example.mikel.miprimeraaplicacion;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Car extends MyListActivity {
  private String Foto_coche;
  private String Nom_coche;
  private String modelo_coche;
    public Car(String Foto_coche , String modelo_coche, String Nom_coche) {
        this.Foto_coche= Foto_coche;
        this.modelo_coche= modelo_coche;
        this.Nom_coche= Nom_coche;
    }

    public String getFoto_coche() {
        return Foto_coche;
    }

    public void setFoto_coche(String Foto_coche) {
        this.Foto_coche = Foto_coche;
    }

    public String getModelo_coche() {
        return modelo_coche;
    }

    public String getNom_coche() {
        return Nom_coche;
    }

    public void setNom_coche(String Nom_coche) {
        this.Nom_coche = Nom_coche;
    }

    @Override
    public String toString()  {
        return this.Nom_coche;
    }

}
