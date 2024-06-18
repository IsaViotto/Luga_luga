package com.example.lugaluga.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lugaluga.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private SQLiteDatabase db;
    private CriarBanco banco;
    public ProdutoController (Context context){
        banco = new CriarBanco(context);
    }

    public List<Produto> carregaProdutos() {
        Cursor cursor;
        List<Produto> produtoList = new ArrayList<>();
        db = banco.getReadableDatabase();
        cursor = db.query("produtos", null, null, null, null, null, null);

        if (db != null) {
            while (cursor.moveToNext()) {
                Produto produto = new Produto();
                produto.setNome(cursor.getString(1));
                produto.setDescricao(cursor.getString(2));
                produto.setPreco(Double.parseDouble(cursor.getString(3)));
                produto.setQuantidade(Integer.parseInt(cursor.getString(4)));
                produto.setStatus(Boolean.valueOf(cursor.getString(5)));
                produtoList.add(produto);
            }
        }

        return produtoList;
    }

}

