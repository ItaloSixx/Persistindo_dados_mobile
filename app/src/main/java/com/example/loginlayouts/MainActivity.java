package com.example.loginlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginlayouts.dao.UserDAO;
import com.example.loginlayouts.helper.BDhelper;
import com.example.loginlayouts.model.User;

public class MainActivity extends AppCompatActivity {
    BDhelper bDhelper;

    EditText edtEmail, edtSenha;
    Button botaologin, botaoregistrar;
    UserDAO uDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bDhelper = new BDhelper(this);
        edtEmail = findViewById(R.id.emaillogin);
        edtSenha = findViewById(R.id.senhatxt);
        botaologin = findViewById(R.id.botalogin);
        botaoregistrar = findViewById(R.id.botaoregistrar);

        botaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();

                boolean loginValido = bDhelper.verificarLogin(email, senha);

                if (loginValido){
                    Intent redirecionar = new Intent(MainActivity.this, ActivityPrincipal.class);
                    redirecionar.putExtra("EMAIL", email);
                    startActivity(redirecionar);
                }else{
                    Toast.makeText(MainActivity.this, "Login inválido. Verifique suas credenciais.", Toast.LENGTH_SHORT).show();

                }

                /* SharedPreferences sp = getSharedPreferences("applogin", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();                                         //PREFERENCIAS, GUARDA ALGUMA INFORMAÇÃO QUE NÃO É INTERESSANTE
                editor.putString("email", edtEmail.getText().toString());                         //OU NECESSÁRIO PERSISTIR NO BANCO DE DADOS PARA USAR EM OUTRO LUGAR, informação como se o usuário está logado
                editor.commit();                                                                       //IDENTIFICAR QUAL USUÁRIO ESTÁ LOGADO

                uDao = new UserDAO(getApplicationContext());
                        new User(edtEmail.getText().toString(),
                                "",
                                edtSenha.getText().toString());

                if (uDao.verificarEmailESenha()){
                    Intent it = new Intent(MainActivity.this, ActivityPrincipal.class);
                    //it.putExtra("email", edtEmail.getText().toString());
                    startActivity(it);
                }

                Toast.makeText(MainActivity.this, edtEmail.getText().toString(), Toast.LENGTH_LONG).show();
                Intent it = new Intent(MainActivity.this, ActivityPrincipal.class);
               //it.putExtra("email", edtEmail.getText().toString()); //PEGAR UMA INFORMAÇÃO E PASSAR PARA OUTRA TELA
                startActivity(it);*/
            }
        });
        botaoregistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent redirecionar = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(redirecionar);  //Redirecionando a activiy, da activity MainActivity para ActivityPrincipal
            }
        });
    }
}