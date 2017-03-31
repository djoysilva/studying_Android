package com.example.rm76983.votacao;

/**
 * Created by logonrm on 30/03/2017.
 */

public class CandidatoBean {
    private String nome;
    private String partido;

    public CandidatoBean() {
    }

    public CandidatoBean(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String toString(){
        return getNome() + "-" + getPartido();
    }
}

