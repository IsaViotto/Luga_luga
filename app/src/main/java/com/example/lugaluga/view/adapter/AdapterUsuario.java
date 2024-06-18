package com.example.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Cliente;
import com.example.lugaluga.model.Produto;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter <AdapterUsuario.ViewHolder> {

    private List<Cliente> listaUsuario;

    public AdapterUsuario(List<Cliente> listaUsuario) {this.listaUsuario = listaUsuario;}

    @NonNull
    @Override
    public AdapterUsuario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listaUsuario = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_buscausu,parent,false);
        return new AdapterUsuario.ViewHolder(listaUsuario);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.ViewHolder holder, int position) {
        holder.nome.setText(listaUsuario.get(position).getNome());
        holder.cpf.setText(listaUsuario.get(position).getCpf());
        holder.email.setText(listaUsuario.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome, cpf, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            cpf = itemView.findViewById(R.id.cpf);
            email = itemView.findViewById(R.id.email);
        }
    }


}
