package com.example.logonpf.fipe;

/**
 * Created by logonrm on 18/05/2017.
 */

public class Veiculo {

    private int id;
    private String nome;

    public Veiculo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
