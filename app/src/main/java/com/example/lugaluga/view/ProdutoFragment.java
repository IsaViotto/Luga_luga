package com.example.lugaluga.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProdutoFragment() {
        // Required empty public constructor
    }

    public static ProdutoFragment newInstance(String param1, String param2) {
        ProdutoFragment fragment = new ProdutoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getContext(), produtoList.get(position).getDescricao(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
        return view;
    }
    public void CriarListaProdutos() {
        Produto produto = new Produto(
                "Iphone 14",
                3000.00,
                "Iphone 14 256GB dourado",
                12,
                true);

        produtoList.add(produto);

        Produto produto2 = new Produto(
                "Iphone 13 pro max",
                2500.00,
                "Iphone 13 256GB branco",
                10,
                true);

        produtoList.add(produto2);

        Produto produto3 = new Produto(
                "AppleWatch",
                1500.00,
                "AppleWatch SE branco",
                5,
                true);

        produtoList.add(produto3);

        Produto produto4 = new Produto(
                "iPad 9",
                2000.00,
                "iPad apple 9th geração",
                3,
                true);

        produtoList.add(produto4);

        Produto produto5 = new Produto(
                "AirPods",
                1800.00,
                "Apple airpods 3th geração",
                10,
                true);

        produtoList.add(produto5);

        Produto produto6 = new Produto(
                "MacBook",
                5700.00,
                "Apple macbook air M1",
                5,
                true);

        produtoList.add(produto6);

        Produto produto7 = new Produto(
                "iPhone 12",
                2300.00,
                "Apple iPhone pro max rosa",
                12,
                true);

        produtoList.add(produto7);

        Produto produto8 = new Produto(
                "AirPods",
                1500.00,
                "Apple airpods 2th geração",
                8,
                true);

        produtoList.add(produto8);

        Produto produto9 = new Produto(
                "iPad 10",
                4000.00,
                "Apple iPad 10th geração",
                6,
                true);

        produtoList.add(produto9);

        Produto produto10 = new Produto(
                "AppleWatch",
                1800.00,
                "AppleWatch rosa",
                7,
                true);

        produtoList.add(produto10);
    }
}