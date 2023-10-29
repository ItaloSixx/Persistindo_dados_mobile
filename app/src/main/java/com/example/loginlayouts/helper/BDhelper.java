package com.example.loginlayouts.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


import androidx.annotation.Nullable;

public class BDhelper extends SQLiteOpenHelper {
    public BDhelper(@Nullable Context context) {
        super(context, "appLogin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE user " +
                "(email TEXT PRIMARY KEY," +
                " senha TEXT," +
                " nome TEXT)";


        sqLiteDatabase.execSQL(sql);
       // sqLiteDatabase.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirUsuario(String email, String senha, String nome) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("senha", senha);
        values.put("nome", nome);

        db.insert("user", null, values);
        db.close();
    }

    public boolean verificarLogin(String email, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                "user",
                null,
                "email = ? AND senha = ?",
                new String[]{email, senha},
                null,
                null,
                null
        );

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }


}

