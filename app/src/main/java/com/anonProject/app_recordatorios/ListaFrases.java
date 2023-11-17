package com.anonProject.app_recordatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListaFrases extends AppCompatActivity {

    private int id;
    private String frase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_frases);
    }
}