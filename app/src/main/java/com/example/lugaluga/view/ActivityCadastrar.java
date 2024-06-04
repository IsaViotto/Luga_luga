package com.example.lugaluga.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lugaluga.R;
import com.example.lugaluga.controller.UsuarioController;
import com.example.lugaluga.model.Cliente;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityCadastrar extends AppCompatActivity{

    private Spinner spinnerUf;

    private TextInputLayout inputCpf, inputNome, inputData, inputCep, inputCidade, inputLogradouro,
            inputNumero, inputComplemento, inputBairro, inputTelefone, inputEmail, inputSenha;

    private Button btnCadastrar;


    @SuppressLint("MissingInflatedId")
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar);

        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolBar);
        myToolBar.setTitle("Luga Luga Cadastro");
        setSupportActionBar(myToolBar);

        inputCpf = findViewById(R.id.cpf);
        inputNome = findViewById(R.id.nome);
        inputData = findViewById(R.id.data);
        inputCep = findViewById(R.id.cep);
        inputCidade = findViewById(R.id.cida);
        inputLogradouro = findViewById(R.id.log);
        inputNumero = findViewById(R.id.num);
        inputComplemento = findViewById(R.id.comp);
        inputTelefone = findViewById(R.id.tele);
        inputEmail = findViewById(R.id.email);
        inputSenha = findViewById(R.id.senha);
        inputBairro = findViewById(R.id.bairro);


        inputCpf.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*","");
                String mask = maskCPF;

                String mascara = "";

                if(isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCpf.getEditText().setText(mascara);
                inputCpf.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputEmail = findViewById(R.id.email);

        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;

            String old = "";

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

        inputCep = findViewById(R.id.cep);

        inputCep.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskCEP = "####-###";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*","");
                String mask = maskCEP;

                String mascara = "";

                if(isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCep.getEditText().setText(mascara);
                inputCep.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinnerUf = (Spinner) findViewById(R.id.spinnerUf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioController crud = new UsuarioController(getApplicationContext());
                Cliente usuario = new Cliente();
                usuario.setNome(inputNome.getEditText().getText().toString());
                usuario.setCpf(inputCpf.getEditText().getText().toString());
                usuario.setData(inputData.getEditText().getText().toString());
                usuario.setCep(inputCep.getEditText().getText().toString());
                usuario.setCidade(inputCidade.getEditText().getText().toString());
                usuario.setLogradouro(inputLogradouro.getEditText().getText().toString());
                usuario.setNumero(Integer.valueOf(inputNumero.getEditText().getText().toString()));
                usuario.setComplemento(inputComplemento.getEditText().getText().toString());
                usuario.setTelefone(inputTelefone.getEditText().getText().toString());
                usuario.setBairro(inputBairro.getEditText().getText().toString());
                usuario.setEmail(inputEmail.getEditText().getText().toString());
                usuario.setSenha(inputSenha.getEditText().getText().toString());

                String resultado;

                resultado = crud.insereDados(usuario.getNome(), usuario.getCpf(), usuario.getData(),usuario.getCep(),
                        usuario.getCidade(), usuario.getLogradouro(),0, usuario.getComplemento(),
                        usuario.getTelefone(), usuario.getBairro(), usuario.getUf(),
                        usuario.getEmail(), usuario.getSenha());
            }
        });
    }
}
