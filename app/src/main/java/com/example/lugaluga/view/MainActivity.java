package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private Button buttonLogin;
    private TextInputLayout inputEmail, inputSenha;

    private Button fazerCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.input_email);
        inputSenha = findViewById(R.id.input_senha);
        buttonLogin= findViewById(R.id.btn1);
        fazerCadastro = findViewById(R.id.btn2);

        Intent intent = new Intent(this, MainActivity3.class);
        Intent intent2 = new Intent(this, ActivityCadastrar.class);

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validaEmailSenha();
                startActivity(intent);
            }
        });

        fazerCadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(intent2);
            }
        });

    }

    public boolean validaEmailSenha(){
        if (inputEmail.getEditText() != null && inputEmail.getEditText().getText().toString().equals("")){
            inputEmail.setError("Informe o email");
            return false;
        }

        if (inputEmail.getEditText() != null && inputSenha.getEditText().getText().toString().equals("")) {
            inputEmail.setError("Informe a senha");
            return false;
        }
        return true;}
}