package com.example.loginlayouts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginlayouts.helper.BDhelper;

public class RegistrarActivity extends AppCompatActivity {
        BDhelper bDhelper;
        Button botaoCadastrar;
        EditText edtEmail, edtSenha, edtNomeCompleto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        bDhelper = new BDhelper(this);

        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        edtEmail = findViewById(R.id.email);
        edtSenha = findViewById(R.id.senha);
        edtNomeCompleto = findViewById(R.id.nomeCompleto);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String nome = edtNomeCompleto.getText().toString();
                String senha = edtSenha.getText().toString();

                bDhelper.inserirUsuario(email, senha, nome);
                Toast.makeText(RegistrarActivity.this, "Registrado com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}