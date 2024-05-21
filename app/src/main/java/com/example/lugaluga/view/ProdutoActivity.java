package com.example.lugaluga.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {


    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descrProduto;

    private Button btnAlugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolBar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.nome);
        qtdProduto = findViewById(R.id.qtd);
        precoProduto = findViewById(R.id.preco);
        descrProduto = findViewById(R.id.descr);

        btnAlugar = findViewById(R.id.btnAlugar);

        produto = getIntent().getExtras().getParcelable("produto");

        if (produto.getStatus().equals("Indisponível")){
            btnAlugar.setEnabled(false);
            btnAlugar.setText("Indisponível");
        }

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(produto.getQuantidade());
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descrProduto.setText(produto.getDescricao());

    }
}