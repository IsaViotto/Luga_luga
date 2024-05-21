package com.example.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Cliente implements Parcelable{
    private String nome;
    private String cpf;
    private Date data;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String email;
    private String senha;

    public Cliente(String nome, String cpf, Date data, String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.senha = senha;
    }

    protected Cliente(Parcel in) {
        nome = in.readString();
        cpf = in.readString();
        cep = in.readString();
        logradouro = in.readString();
        if (in.readByte() == 0) {
            numero = null;
        } else {
            numero = in.readInt();
        }
        complemento = in.readString();
        bairro = in.readString();
        cidade = in.readString();
        uf = in.readString();
        email = in.readString();
        senha = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(cpf);
        dest.writeString(cep);
        dest.writeString(logradouro);
        if (numero == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numero);
        }
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(cidade);
        dest.writeString(uf);
        dest.writeString(email);
        dest.writeString(senha);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
