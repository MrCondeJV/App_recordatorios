package com.anonProject.app_recordatorios.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.anonProject.app_recordatorios.ListaActividades;
import com.anonProject.app_recordatorios.ListaFrases;

import java.util.ArrayList;

public class dbFrases extends DbHelper{

    Context context;
    public dbFrases(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarFrase(String frase){
        long id=0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("frase", frase);

            id = db.insert(TABLE_FRASES, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<ListaFrases> mostrarFrases(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<ListaFrases> listaFrases = new ArrayList<>();
        ListaFrases frases = null;
        Cursor cursorFrases = null;

        cursorFrases = db.rawQuery("SELECT * FROM " + TABLE_FRASES, null);
        if(cursorFrases.moveToFirst()){
            do{
                frases = new ListaFrases();
                frases.setId(cursorFrases.getInt(0));
                frases.setFrase(cursorFrases.getString(1));
                listaFrases.add(frases);

            }while (cursorFrases.moveToNext());
        }
        cursorFrases.close();
        return listaFrases;
    }
}
