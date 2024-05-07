package com.example.lugaluga.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {


    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descrProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nome);
        qtdProduto = findViewById(R.id.qtd);
        precoProduto = findViewById(R.id.preco);
        descrProduto = findViewById(R.id.descr);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(produto.getQuantidade());
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descrProduto.setText(produto.getDescricao());

    }
}