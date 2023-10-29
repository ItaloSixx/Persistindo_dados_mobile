package com.example.loginlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityPrincipal extends AppCompatActivity {
        TextView textEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        textEmail = findViewById(R.id.textEmail);

        /*SharedPreferences sp = getSharedPreferences("applogin", Context.MODE_PRIVATE);
        String email = sp.getString("email", "nada encontrado");                //pegando as informações do SharedPReferences
        textEmail.setText(email);


        //Intent it = getIntent();
        //String email = it.getStringExtra("email");  //PEGAR A INFORMAÇÃO PASSADA PARA OUTRA TELA
        //textEmail.setText(email);*/
    }
}