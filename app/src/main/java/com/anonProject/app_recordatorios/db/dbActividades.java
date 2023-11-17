package com.anonProject.app_recordatorios.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.anonProject.app_recordatorios.ListaActividades;

import java.util.ArrayList;

public class dbActividades extends DbHelper{

    Context context;
    public dbActividades(@Nullable Context context) {
        super(context);
        this.context = context;

    }

    public long insertarActividad(String nombreActividad, String descripcionActividad){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre_actividad", nombreActividad);
            values.put("descripcion_actividad", descripcionActividad);

           id = db.insert(TABLE_ACTIVIDADES, null, values);
        }catch (Exception ex){
            ex.toString();
        }
      return id;
    }

    public ArrayList<ListaActividades> mostrarActividades(){

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ArrayList<ListaActividades> listaActividades = new ArrayList<>();
            ListaActividades actividades = null;
            Cursor cursorActividades = null;

            cursorActividades = db.rawQuery("SELECT * FROM " + TABLE_ACTIVIDADES, null);
            if(cursorActividades.moveToFirst()){
                do{
                    actividades = new ListaActividades();
                    actividades.setId(cursorActividades.getInt(0));
                    actividades.setNombreActividad(cursorActividades.getString(1));
                    actividades.setDescripcionActividad(cursorActividades.getString(2));
                    listaActividades.add(actividades);

                }while (cursorActividades.moveToNext());
            }
            cursorActividades.close();
            return listaActividades;
    }
}
