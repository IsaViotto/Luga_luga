package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity2.this, ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), produtoList.get(position).getDescricao(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void CriarListaProdutos(){
        Produto produto = new Produto(
                "Iphone 14",
                3000.00,
                "Iphone 14 256GB dourado",
                12,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "Iphone 13 pro max",
                2500.00,
                "Iphone 13 256GB branco",
                10,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "AppleWatch",
                1500.00,
                "AppleWatch SE branco",
                5,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "iPad 9",
                2000.00,
                "iPad apple 9th geração",
                3,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "AirPods",
                1800.00,
                "Apple airpods 3th geração",
                10,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "MacBook",
                5700.00,
                "Apple macbook air M1",
                5,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "iPhone 12",
                2300.00,
                "Apple iPhone pro max rosa",
                12,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "AirPods",
                1500.00,
                "Apple airpods 2th geração",
                8,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "iPad 10",
                4000.00,
                "Apple iPad 10th geração",
                6,
                true);

        produtoList.add(produto);

        produto = new Produto(
                "AppleWatch",
                1800.00,
                "AppleWatch rosa",
                7,
                true);

        produtoList.add(produto);
    }

}