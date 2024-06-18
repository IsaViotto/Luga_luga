package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lugaluga.R;
import com.example.lugaluga.controller.UsuarioController;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

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

        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern pattern;
                Matcher matcher;
                String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(EMAIL_PATTERN);
                CharSequence cs = (CharSequence) s;
                matcher = pattern.matcher(cs);
                if (!(matcher.matches() == true)) {
                    inputEmail.setError("Invalid email");
                } else {
                    inputEmail.setError("");
                }
            }
        });

        Intent intent = new Intent(this, MainActivity3.class);


        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(validaEmailSenha() && verificaUsuario());
                startActivity(intent);
            }
        });

        Intent intent2 = new Intent(this, ActivityCadastrar.class);

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

    private boolean verificaUsuario(){
        String email = inputEmail.getEditText().getText().toString();

        String senha = inputSenha.getEditText().getText().toString();

        UsuarioController usuarioController = new UsuarioController(getApplicationContext());

        if(usuarioController.verificaUsuario(email, senha)){
            return true;
        }

        return false;
    }
}