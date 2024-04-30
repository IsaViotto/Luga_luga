package com.example.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;

public class adapterProduto extends RecyclerView.Adapter<adapterProduto.ViewHolder> {
    @NonNull
    @Override
    public adapterProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listaProdutos = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);
        return new ViewHolder(listaProdutos);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterProduto.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView produto_nome, produto_preco, produto_descr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            produto_nome = itemView.findViewById(R.id.produto_nome);
            produto_preco = itemView.findViewById(R.id.produto_preco);
            produto_descr = itemView.findViewById(R.id.produto_descr);
        }
    }
}
