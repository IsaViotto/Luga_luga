package com.example.lugaluga.view;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lugaluga.R;

public class ActivityCadastrar extends AppCompatActivity{

    private Spinner spinnerUf;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar);

        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolBar);
        myToolBar.setTitle("Luga Luga Cadastro");
        setSupportActionBar(myToolBar);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerUf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);
    }
}
