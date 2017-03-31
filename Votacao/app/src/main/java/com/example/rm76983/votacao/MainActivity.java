package com.example.rm76983.votacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CandidatoBean> prefeitos;
    private List<CandidatoBean> vereadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void criarCandidatos(){
        prefeitos = new ArrayList<CandidatoBean>();
        prefeitos.add(new CandidatoBean("Zé da Feira", "XTC"));
        prefeitos.add(new CandidatoBean("Maria Melhor", "LLL"));
        prefeitos.add(new CandidatoBean("Brandão Filho", "ZTO"));
    }

}
