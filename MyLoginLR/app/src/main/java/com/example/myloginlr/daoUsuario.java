package com.example.myloginlr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context o;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="DBUsuarios";
    String tabla="create table usuario(id integer primary key autoincrement,usuario text, pass text, nombre text, ap text)";

    public daoUsuario(Context c){
       this.c=c;
       sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
       sql.execSQL(tabla);
       u=new Usuario();
    }

    public boolean insertUsuario(Usuario u){
    if(buscar(u.getUsuario())==0) {
        ContentValues cv = new ContentValues();
        cv.put("usuario", u.getUsuario());
        cv.put("pass", u.getPassword());
        cv.put("nombre", u.getNombre());
        cv.put("ap", u.getApellidos());
        return (sql.insert("usuario", null, cv) > 0);
    }else{
        return false;
    }

    }
    public int buscar(String u){
     int x=0;

    }

    public ArrayList<Usuario> selectUsuario(){
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.movetoFirst()){
            do{

            }while(cr.moveToNext());
        }

    }
}
