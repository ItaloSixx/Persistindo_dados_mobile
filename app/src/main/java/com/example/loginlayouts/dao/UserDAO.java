package com.example.loginlayouts.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.loginlayouts.helper.BDhelper;
import com.example.loginlayouts.model.User;

public class UserDAO {
    private User user;
    private BDhelper db;

    public UserDAO(Context ctx) {
        this.db = new BDhelper(ctx);
        this.user = user;
    }
                                                                            //NAO ESTOU UTILIZANDO O DAO//----------
    public boolean verificarEmailESenha(){

        SQLiteDatabase dbLite = this.db.getReadableDatabase(); //metodo somente para leitura
       // SQLiteDatabase dbLite = this.db.getWritableDatabase(); //metodo para escrita
        String sql = "SELECT * FROM User where email = ? AND senha = ?"; //se vier algo esta correto(?)
        Cursor cursor = dbLite.rawQuery(sql,                 //metodo ultilizado para fazer consultas
                new String[]{user.getEmail(), this.user.getSenha()});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;}
    }


}
