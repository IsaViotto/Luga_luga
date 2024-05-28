package com.example.lugaluga.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

public class ActivityCadastrar extends AppCompatActivity{

    private Spinner spinnerUf;

    private TextInputLayout inputCpf;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar);

        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolBar);
        myToolBar.setTitle("Luga Luga Cadastro");
        setSupportActionBar(myToolBar);

        inputCpf = findViewById(R.id.cpf);

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

        spinnerUf = (Spinner) findViewById(R.id.spinnerUf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);
    }
}
